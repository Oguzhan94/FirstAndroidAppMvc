package com.hr200009.oguzhan_gunduz_final.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.hr200009.oguzhan_gunduz_final.Model.MovieModel;
import com.hr200009.oguzhan_gunduz_final.R;
import com.hr200009.oguzhan_gunduz_final.Util.GlideUtil;

import java.util.List;

import io.reactivex.annotations.NonNull;

//RecyclerView'in calismasi icin gerekli olan Adaptor sinifidir.
public class MovieAdaptor extends RecyclerView.Adapter<MovieViewHolder>{

    List<MovieModel> movies;
    Context context;
    OnItemClickListener listener;

// Sinif Constractor'i
    public MovieAdaptor(List<MovieModel> movies, Context context, OnItemClickListener listener) {
        this.movies = movies;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    //ViewHolder olusturan fonksiyon
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.movies_card_view, parent, false);
        return new MovieViewHolder(item,listener);
    }

    @Override
    //ViewHolder icine datalari setleyen fonksiyon
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.movieName.setText(movies.get(position).getName());
        holder.movieGenres.setText(movies.get(position).getGenres());
        holder.movieStars.setText(movies.get(position).getStars());
        GlideUtil.getPhotosToInternet(context,movies.get(position).getPhotoUrl(), holder.movieImage);
    }

    @Override
    //Datalarin uzunlugunu donduren fonksiyon
    public int getItemCount() {
        return movies.size();
    }

// Click eventi icin kullanilan fonksiyon
    public interface OnItemClickListener{
        void onItemClick (int selectedMovie);
    }



}
