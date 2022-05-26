package com.hr200009.oguzhan_gunduz_final.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import androidx.appcompat.app.AppCompatActivity;

import com.hr200009.oguzhan_gunduz_final.R;
import com.hr200009.oguzhan_gunduz_final.Util.AlertUtil;
import com.hr200009.oguzhan_gunduz_final.Util.NetworkUtil;

@SuppressLint("CustomSplashScreen")
// Bu dosya Splash Ekranidir,  Uygulama bu ekrandan basliyor.
public class SplashActivity extends AppCompatActivity {

    @Override
    //Acilista calisan fonksiyondur ve activity_splash.xml ile bağlıdır.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        startTimer();
    }

    // Internet durumunu kontrol eden fonksiyon. Donen deger true ise openToListScreen fonksiyonunu cagirir, degilse AlertUtil sınıfından internetAlert fonksiyonunu cagirir
    private void showInternetStatus() {

        if (NetworkUtil.isInternetActive(getApplicationContext())) {
            openToListScreen();
        } else {
            AlertUtil.internetAlert(getString(R.string.internetAlertTitle), getString(R.string.internetAlertMessage), getString(R.string.internetAlertNegativeButton), getString(R.string.internetAlertPositiveButton), this);
        }
    }

    // Uygulama basladiginde sayac baslatip, süre bitince showInternetStatus fonksiyonunu cagirir
    private void startTimer() {

        CountDownTimer countDownTimer = new CountDownTimer(getResources().getInteger(R.integer.SplashScreenCountDownTimerFuture), getResources().getInteger(R.integer.SplashScreenCountDownTimerInterval)) {
            @Override
            public void onTick(long l) {
            }

            @Override
            public void onFinish() {
                showInternetStatus();
            }
        };
        countDownTimer .start();
    }

    // ListActivity ekranina yonlendiren fonksiyon
    private void openToListScreen() {

        Intent listScreen = new Intent(SplashActivity.this, ListActivity.class);
        startActivity(listScreen);
        finish();
    }

}