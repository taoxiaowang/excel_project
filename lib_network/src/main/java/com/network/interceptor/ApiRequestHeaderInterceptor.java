package com.network.interceptor;

import android.annotation.SuppressLint;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * create by taowang at 2020/10/11
 * <p>
 * Api 请求头添加
 * 1.添加token
 **/
public class ApiRequestHeaderInterceptor implements Interceptor {


    public ApiRequestHeaderInterceptor() {
    }

    @SuppressLint("CheckResult")
    @Override
    public Response intercept(Chain chain) throws IOException {

        return chain.proceed(chain.request());
    }
}
