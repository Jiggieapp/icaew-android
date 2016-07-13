package com.jt.icaew.android.network.about;

import com.google.gson.Gson;
import com.jt.icaew.android.network.BaseNetworkManager;
import com.jt.icaew.android.network.CustomCallback;
import com.jt.icaew.android.network.OnResponseListener;
import com.jt.icaew.android.utils.Utils;

import retrofit2.Response;

/**
 * Created by Wandy on 7/12/2016.
 */
public class AboutManager extends BaseNetworkManager{

    public static void getAbout(final OnResponseListener onResponseListener)
    {
        getAbout(new CustomCallback() {
            @Override
            public void onCustomCallbackResponse(Response response) {
                onResponseListener.onSuccess(response.body());
            }

            @Override
            public void onCustomCallbackFailure(String t) {

            }
        });
    }

    private static void getAbout(CustomCallback customCallback)
    {
        getInstance().getAbout().enqueue(customCallback);
    }

    private static AboutInterface aboutInterface;
    private static AboutInterface getInstance()
    {
        if(aboutInterface == null)
            aboutInterface = getRetrofit().create(AboutInterface.class);
        return aboutInterface;
    }


}
