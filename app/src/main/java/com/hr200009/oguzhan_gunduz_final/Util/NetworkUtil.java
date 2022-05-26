package com.hr200009.oguzhan_gunduz_final.Util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

// Internet varlıgını kontrol etmemize yarayan sinif
public class NetworkUtil {

    public static boolean isInternetActive(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null
                && networkInfo.isAvailable()
                && networkInfo.isConnected();
    }
}
