package com.booyue.demo.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by 15272 on 2017/7/8.
 *
 * 网络请求管理类
 */
public class HttpUtil {

    public static void sendOkHttpRequest(String address,okhttp3.Callback callback){

        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder().url(address).build();

        okHttpClient.newCall(request).enqueue(callback);






    }

}
