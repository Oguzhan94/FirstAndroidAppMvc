package com.hr200009.oguzhan_gunduz_final.Adaptor;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.hr200009.oguzhan_gunduz_final.R;

import io.reactivex.annotations.NonNull;
//RecyclerView'in calismasi icin gerekli olan Holder sinifidir.

public class MovieViewHolder extends RecyclerView.ViewHolder {

    ImageView movieImage;
    TextView movieName;
    TextView movieGenres;
    TextView movieStars;

// Verilen viewleri set etmek icin kullanilan fonksiyon
    public MovieViewHolder(@NonNull View itemView, MovieAdaptor.OnItemClickListener listener) {
        super(itemView);

        movieImage = itemView.findViewById(R.id.imgMovie);
        movieName = itemView.findViewById(R.id.txtMovieName);
        movieGenres = itemView.findViewById(R.id.txtMovieGender);
        movieStars = itemView.findViewById(R.id.txtMovieStar);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(getAdapterPosition());
            }
        });
    }
}
