package com.hr200009.oguzhan_gunduz_final.Util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;

import androidx.appcompat.app.AlertDialog;

// Alert diyalogu olusturdugumuz sinif.
public class AlertUtil {
    public static void internetAlert(String title, String message, String negativeButton, String positiveButton, Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setNegativeButton(negativeButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                activity.finish();
            }
        });
        builder.setPositiveButton(positiveButton, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        activity.startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                    }
                }
        );
        builder.show();
    }
}
