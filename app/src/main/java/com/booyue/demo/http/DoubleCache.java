package com.booyue.demo.http;

import android.graphics.Bitmap;

/**
 * Created by 15272 on 2017/7/12.
 *
 */
public class DoubleCache implements ImageCache{

    MemoryCache mMemoryCache = new MemoryCache();

    DiskCache diskCache = new DiskCache();


    public void put(String url, Bitmap bitmap) {
        mMemoryCache.put(url, bitmap);
        diskCache.put(url, bitmap);
    }


    public Bitmap get(String url) {
        Bitmap bitmap = mMemoryCache.get(url);
        if (bitmap == null) {
            bitmap = diskCache.get(url);
        }
        return bitmap;
    }
}
