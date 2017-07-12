package com.booyue.demo.http;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by 15272 on 2017/7/12.
 *
 * 磁盘缓存
 */
public class DiskCache implements ImageCache{

    static String cacheDir = "sdcard/cache/";

    /**
     * 从磁盘中获取图片
     * @param url
     * @return
     */
    public Bitmap get(String url){
        return BitmapFactory.decodeFile(cacheDir + url);

    }

    /**
     * 将图片保存在磁盘中
     * @param url 保存的地址
     * @param bitmap 保存的图片
     */
    public void put(String url,Bitmap bitmap){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(cacheDir + url);

            bitmap.compress(Bitmap.CompressFormat.PNG,100,fileOutputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                    fileOutputStream = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}
