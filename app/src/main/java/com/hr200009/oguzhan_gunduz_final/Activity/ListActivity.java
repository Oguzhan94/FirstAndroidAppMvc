package com.hr200009.oguzhan_gunduz_final.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hr200009.oguzhan_gunduz_final.Adaptor.MovieAdaptor;
import com.hr200009.oguzhan_gunduz_final.Model.MovieModel;
import com.hr200009.oguzhan_gunduz_final.Network.Service;
import com.hr200009.oguzhan_gunduz_final.R;
import com.hr200009.oguzhan_gunduz_final.Util.Constants;
import com.hr200009.oguzhan_gunduz_final.Util.GlideUtil;
import com.hr200009.oguzhan_gunduz_final.Util.ObjectUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

// Bu sınıf List Ekranidir. activity_detail.xml ile bağlıdır.
public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView imageView;


    @Override
    // Ekran buradan basliyor ve init adında bir fonksiyonu cagiriyor
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        init();

    }
// movieRequestAndList fonksiyonunu cagiriyor
    private void init() {
        movieRequestAndList();
    }

// Gelen listeyi MovieAdaptor ile bağlanmasini sagliyor ve secilen filmin ekraninin acilmasi icin click eventi aliyor
    private void initRecycleView(List<MovieModel> movieList) {

        recyclerView = findViewById(R.id.rcvMovies);
        MovieAdaptor movieAdaptor = new MovieAdaptor(movieList, getApplicationContext(), new MovieAdaptor.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                MovieModel selectedMovie = movieList.get(position);
                openSelectedMovieScreen(selectedMovie);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(movieAdaptor);

    }

//Sunucudan resim verisini ceken fonksiyon
    private void getAppInfoPhoto() {

        imageView = findViewById(R.id.appInfoPhoto);
        GlideUtil.getPhotosToInternet(getApplicationContext(), "https://raw.githubusercontent.com/Oguzhan94/hr200009oguzhangunduz/main/appInfoPhoto.jpg", imageView);

    }

// Retrofit ve OkHttp kütüphanelerinin fonksiyonlarini kullanarak sunucu ustunden json verisi cekmek
// icin kullaniyoruz. Cekilen veriler recyclerView icine liste olarak atiliyor
    private void movieRequestAndList() {

        new Service().getServiceApi().getMovies().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<MovieModel>>() {
                    List<MovieModel> movies = new ArrayList<>();

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<MovieModel> movieModelList) {
                        movies = movieModelList;
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        if (movies.size() > 0) {
                            initRecycleView(movies);
                        }
                    }
                });

        getAppInfoPhoto();

    }

// Secilen filmin detay ekranini acan fonksiyon
// Ekranlar arası veri ve obje tasiniyor
    private void openSelectedMovieScreen(MovieModel selectedMovie) {

        Intent movieDetailScreen = new Intent(getApplicationContext(), DetailActivity.class);
        String selectedMovieTitle = ObjectUtil.movieJsonString(selectedMovie);
        movieDetailScreen.putExtra(Constants.selected_Movie, selectedMovieTitle);
        startActivity(movieDetailScreen);

    }

// Geri gelme tusuna basilinca alert cikartan fonksiyon
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.listScreenAlertTitle));
        builder.setMessage(getResources().getString(R.string.listScreenAlertMessage));
        builder.setPositiveButton(getResources().getString(R.string.listScreenAlertPositive), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        builder.setNegativeButton(getResources().getString(R.string.listScreenAlertNegative), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        builder.show();

    }
}