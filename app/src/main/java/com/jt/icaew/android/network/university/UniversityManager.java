package com.jt.icaew.android.network.university;

import com.jt.icaew.android.network.BaseNetworkManager;
import com.jt.icaew.android.network.CustomCallback;
import com.jt.icaew.android.network.OnResponseListener;

import retrofit2.Response;

/**
 * Created by LTE on 7/13/2016.
 */
public class UniversityManager extends BaseNetworkManager {

    public static void getUniversity(final OnResponseListener onResponseListener)
    {
        getUniversity(new CustomCallback() {
            @Override
            public void onCustomCallbackResponse(Response response) {
                onResponseListener.onSuccess(response.body());
            }

            @Override
            public void onCustomCallbackFailure(String t) {

            }
        });
    }

    public static void getUniversityDetail(String country_id, final OnResponseListener onResponseListener){
        getUniversityDetails(country_id, new CustomCallback() {
            @Override
            public void onCustomCallbackResponse(Response response) {
                onResponseListener.onSuccess(response.body());
            }

            @Override
            public void onCustomCallbackFailure(String t) {

            }
        });
    }

    private static void getUniversity(final CustomCallback callback)
    {
        getInstance().getCountry().enqueue(callback);
    }

    private static void getUniversityDetails(String country_id, final CustomCallback callback)
    {
        getInstance().getUniversityList(country_id).enqueue(callback);
    }

    private static UniversityInterface instance;
    private static UniversityInterface getInstance()
    {
        if(instance == null)
            instance = getRetrofit().create(UniversityInterface.class);
        return instance;
    }
}
