package com.booyue.demo.http;

import android.graphics.Bitmap;

/**
 * Created by 15272 on 2017/7/12.
 */
public interface ImageCache {

    public void put(String url, Bitmap bitmap);

    public Bitmap get(String url);


}
