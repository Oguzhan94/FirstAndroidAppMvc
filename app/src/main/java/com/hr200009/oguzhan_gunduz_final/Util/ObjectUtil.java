package com.hr200009.oguzhan_gunduz_final.Util;

import com.google.gson.Gson;
import com.hr200009.oguzhan_gunduz_final.Model.MovieModel;

// Json'u java modeline onuda stringe ceviren sinif.
public class ObjectUtil {
    public static String movieJsonString(MovieModel movieModel) {

        Gson gson = new Gson();
        return gson.toJson(movieModel);
    }

    public static MovieModel jsonStringMovie(String jsonString) {

        Gson gson = new Gson();
        return gson.fromJson(jsonString, MovieModel.class);
    }
}
