package com.booyue.demo.http;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 15272 on 2017/7/11.
 *
 * 图片的加载
 */
public class ImageLoader {

    LruCache<String, Bitmap> mImageCache;

    ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public ImageLoader() {

        initImageCache();
    }

    /**
     * 初始化Imageview
     */
    private void initImageCache() {

        final int maxMemory = (int) Runtime.getRuntime().maxMemory() / 1024;

        int cacheSize = maxMemory / 4;

        mImageCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {

                return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
            }
        };

    }

    /**
     * 展示图片
     *
     * @param url       图片的url
     * @param imageView 展示图片的imageview
     */
    public void displayImage(final String url, final ImageView imageView) {
        imageView.setTag(url);
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downloadImage(url);
                if (bitmap == null) return;
                if (imageView.getTag().equals(url)) {
                    imageView.setImageBitmap(bitmap);
                }

                mImageCache.put(url, bitmap);
            }
        });

    }

    /**
     * 下载图片
     *
     * @param imageUrl 请求的image url
     * @return bitmap
     */
    private Bitmap downloadImage(String imageUrl) {
        try {
            URL url = new URL(imageUrl);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setRequestMethod("GET");

            httpURLConnection.connect();

            InputStream inputStream = httpURLConnection.getInputStream();

            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

            httpURLConnection.disconnect();

            return bitmap;
        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;
    }

}
