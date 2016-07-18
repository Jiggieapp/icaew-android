package com.jt.icaew.android.network;

/**
 * Created by Wandy on 7/11/2016.
 */
public interface  OnResponseListener {
    void onSuccess(Object object);
    void onFailure(String message);
}
