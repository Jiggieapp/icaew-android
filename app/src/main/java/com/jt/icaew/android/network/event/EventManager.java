package com.jt.icaew.android.network.event;

import com.jt.icaew.android.network.BaseNetworkManager;
import com.jt.icaew.android.network.CustomCallback;
import com.jt.icaew.android.network.OnResponseListener;

import javax.security.auth.callback.Callback;

import retrofit2.Response;

/**
 * Created by Wandy on 7/11/2016.
 */
public class EventManager extends BaseNetworkManager {

    private static EventInterface instance;
    private static EventInterface getInstance()
    {
        if(instance == null)
            instance = getRetrofit().create(EventInterface.class);
        return instance;
    }

    public static void getEvent(final OnResponseListener onResponseListener)
    {
        getEvent(new CustomCallback() {
            @Override
            public void onCustomCallbackResponse(Response response) {
                onResponseListener.onSuccess(response.body());
            }

            @Override
            public void onCustomCallbackFailure(String t) {

            }
        });
    }

    private static void getEvent(final CustomCallback callback)
    {
        getInstance().getCountry().enqueue(callback);
    }

    public static void getEventDetail(final String countryId, final OnResponseListener onResponseListener) {
        getEventDetail(countryId, new CustomCallback() {
            @Override
            public void onCustomCallbackResponse(Response response) {
                onResponseListener.onSuccess(response.body());
            }

            @Override
            public void onCustomCallbackFailure(String t) {

            }
        });
    }

    private static void getEventDetail(final String id, CustomCallback callback) {
        getInstance().getEventDetail(id).enqueue(callback);
    }
}
