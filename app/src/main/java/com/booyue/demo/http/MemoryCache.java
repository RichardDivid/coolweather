package com.booyue.demo.http;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by 15272 on 2017/7/11.
 */
public class MemoryCache implements ImageCache{

    private int maxMemory;
    private int cacheSize;
    private LruCache<String, Bitmap> mImageCache;

    public MemoryCache() {
        initImageCache();

    }

    private void initImageCache() {
        //计算可使用最大的内存
        maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);

        //取最大内存的1/4作为缓存

        cacheSize = maxMemory / 4;

        mImageCache = new LruCache<String, Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    }

    /**
     *
     * @param imageUrl 缓存图片的key
     * @param bitmap  缓存的图片
     */
    public void put(String imageUrl,Bitmap bitmap){
        mImageCache.put(imageUrl,bitmap);
    }

    /**
     * 获取图片
     * @param imageUrl 需要取出对应的key
     * @return 取出的bitmap
     */
    public Bitmap get(String imageUrl){
        return mImageCache.get(imageUrl);
    }


}
