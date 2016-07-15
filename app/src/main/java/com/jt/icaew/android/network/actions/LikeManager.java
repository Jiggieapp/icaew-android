package com.jt.icaew.android.network.actions;

import com.jt.icaew.android.network.BaseNetworkManager;
import com.jt.icaew.android.network.CustomCallback;
import com.jt.icaew.android.network.OnResponseListener;

import retrofit2.Response;

/**
 * Created by LTE on 7/15/2016.
 */
public class LikeManager extends BaseNetworkManager {

    private static LikeInterface instance;
    private static LikeInterface getInstance()
    {
        if(instance == null)
            instance = getRetrofit().create(LikeInterface.class);
        return instance;
    }

    private static void putLike(String id, CustomCallback customCallback)
    {
        getInstance().putLike(id).enqueue(customCallback);
    }

    public static void putLike(final String id, final OnResponseListener onResponseListener)
    {
        putLike(id, new CustomCallback() {
            @Override
            public void onCustomCallbackResponse(Response response) {
                onResponseListener.onSuccess(response.body());
            }

            @Override
            public void onCustomCallbackFailure(String t) {
                onResponseListener.onFailure(404, "failure");
            }
        });
    }

}
