package com.jt.icaew.android.network.country;

import com.jt.icaew.android.network.BaseNetworkManager;
import com.jt.icaew.android.network.CustomCallback;
import com.jt.icaew.android.network.OnResponseListener;

import retrofit2.Response;

/**
 * Created by Wandy on 7/15/2016.
 */
public class CountryManager extends BaseNetworkManager {
    private static CountryInterface instance;
    private static CountryInterface getInstance()
    {
        if(instance == null)
            instance = getRetrofit().create(CountryInterface.class);
        return instance;
    }

    public static void getCountry(final OnResponseListener onResponseListener)
    {
        getCountry(new CustomCallback() {
            @Override
            public void onCustomCallbackResponse(Response response) {
                onResponseListener.onSuccess(response.body());
            }

            @Override
            public void onCustomCallbackFailure(String t) {

            }
        });
    }

    private static void getCountry(final CustomCallback callback)
    {
        getInstance().getCountry().enqueue(callback);
    }
}
