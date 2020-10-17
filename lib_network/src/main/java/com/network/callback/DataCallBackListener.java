package com.network.callback;

/**
 * author : taowang
 * date :2020/10/11
 * description:
 **/
public interface DataCallBackListener<T> {
    void onSuccess(T data);

    void onError(String code, String msg);
}
