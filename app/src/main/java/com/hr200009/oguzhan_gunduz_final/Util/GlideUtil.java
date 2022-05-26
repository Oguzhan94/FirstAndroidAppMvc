package com.hr200009.oguzhan_gunduz_final.Util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hr200009.oguzhan_gunduz_final.R;

// sunucudan fotograf cekmemizi saglayan kutuphane
public class GlideUtil {

    public static void getPhotosToInternet(Context context, String imageUrl, ImageView imageView) {
        Glide.with(context)
                .load(imageUrl)
                .error(R.drawable.app_logo)
                .into(imageView);
    }
}
