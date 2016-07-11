package com.jt.icaew.android.network;

import retrofit2.Response;

/**
 * Created by Wandy on 7/11/2016.
 */
public class ProgramManager extends BaseNetworkManager {

    public static void getProgram() {
        ProgramManager.getProgram(
                new OnResponseListener() {
                    @Override
                    public void onSuccess(Object object) {

                    }

                    @Override
                    public void onFailure(int responseCode, String message) {

                    }
                }
        );
    }

    public static void getProgram(final OnResponseListener onResponseListener) {
        getProgram(new CustomCallback() {
            @Override
            public void onCustomCallbackResponse(Response response) {
                onResponseListener.onSuccess(response.body());
            }

            @Override
            public void onCustomCallbackFailure(String t) {

            }
        });
    }

    private static void getProgram(CustomCallback callback)
    {
        getInstance().getProgram().enqueue(callback);
    }

    private static ProgramInterface instance;
    private static ProgramInterface getInstance()
    {
        if(instance == null)
            instance = getRetrofit().create(ProgramInterface.class);
        return instance;
    }
}
