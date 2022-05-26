package com.hr200009.oguzhan_gunduz_final.Network;


import com.hr200009.oguzhan_gunduz_final.Model.MovieModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {
// Gelen degisikligi surekli kontrol eden yapi
    @GET("movieinfo.json")
    Observable<List<MovieModel>> getMovies();
}
