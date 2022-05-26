package com.hr200009.oguzhan_gunduz_final.Activity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.hr200009.oguzhan_gunduz_final.Model.MovieModel;
import com.hr200009.oguzhan_gunduz_final.R;
import com.hr200009.oguzhan_gunduz_final.Util.Constants;
import com.hr200009.oguzhan_gunduz_final.Util.GlideUtil;
import com.hr200009.oguzhan_gunduz_final.Util.ObjectUtil;

// Bu sınıf Detay Ekranidir. activity_detail.xml ile bağlıdır.
public class DetailActivity extends AppCompatActivity {

    ImageView moviesPhoto;
    TextView moviesTitle;
    TextView moviesInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        init();
    }

    //Jsondan donen fotograf ve bilgileri Html olarak detay ekranina basan fonksiyon
    private void init() {
        String getMovieInfoString = getIntent().getStringExtra(Constants.selected_Movie);
        MovieModel movieModel = ObjectUtil.jsonStringMovie(getMovieInfoString);
        moviesPhoto = findViewById(R.id.imageInfo);
        moviesTitle = findViewById(R.id.txtTitle);
        moviesInfo = findViewById(R.id.txtInfo);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            moviesTitle.setText(Html.fromHtml(movieModel.getName(), Html.FROM_HTML_MODE_LEGACY));
            moviesInfo.setText(Html.fromHtml(movieModel.getDetail(), Html.FROM_HTML_MODE_LEGACY));
        } else {
            moviesTitle.setText(Html.fromHtml(movieModel.getName()));
            moviesInfo.setText(Html.fromHtml(movieModel.getDetail()));
        }
        GlideUtil.getPhotosToInternet(getApplicationContext(), movieModel.getPhotoUrl(), moviesPhoto);
    }

}