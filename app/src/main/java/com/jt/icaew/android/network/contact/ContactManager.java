package com.jt.icaew.android.network.contact;

import com.jt.icaew.android.network.BaseNetworkManager;
import com.jt.icaew.android.network.CustomCallback;
import com.jt.icaew.android.network.OnResponseListener;
import com.jt.icaew.android.utils.Utils;

import retrofit2.Response;

/**
 * Created by Wandy on 7/12/2016.
 */
public class ContactManager extends BaseNetworkManager{

    private static ContactInterface instance;
    private static ContactInterface getInstance()
    {
        if(instance == null)
            instance = getRetrofit().create(ContactInterface.class);
        return instance;
    }

    /*public static void getContactUsCountry(final OnResponseListener onResponseListener)
    {
        getContactUsCountry(new CustomCallback() {
            @Override
            public void onCustomCallbackResponse(Response response) {
                onResponseListener.onSuccess(response.body());
            }

            @Override
            public void onCustomCallbackFailure(String t) {

            }
        });
    }*/

    /*private static void getContactUsCountry(CustomCallback customCallback)
    {
        getInstance().getContactUsCountry().enqueue(customCallback);
    }*/

    public static void getContactUsDetail(final String id, final OnResponseListener onResponseListener)
    {
        getContactUsDetail(id, new CustomCallback() {
            @Override
            public void onCustomCallbackResponse(Response response) {
                onResponseListener.onSuccess(response.body());
            }

            @Override
            public void onCustomCallbackFailure(String t) {
                onResponseListener.onFailure(t);
            }
        });
    }

    private static void getContactUsDetail(final String id, final CustomCallback callback)
    {
        getInstance().getContactUsDetail(id).enqueue(callback);
    }
}
