package com.jt.icaew.android.network.program;

import com.jt.icaew.android.network.BaseNetworkManager;
import com.jt.icaew.android.network.CustomCallback;
import com.jt.icaew.android.network.OnResponseListener;

import retrofit2.Response;

/**
 * Created by Wandy on 7/11/2016.
 */
public class ProgramManager extends BaseNetworkManager {

    private static ProgramInterface instance;
    private static ProgramInterface getInstance()
    {
        if(instance == null)
            instance = getRetrofit().create(ProgramInterface.class);
        return instance;
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

    public static void getProgramDetail(final String id, final OnResponseListener onResponseListener)
    {
        getProgramDetail(id, new CustomCallback() {
            @Override
            public void onCustomCallbackResponse(Response response) {
                onResponseListener.onSuccess(response.body());
            }

            @Override
            public void onCustomCallbackFailure(String t) {

            }
        });
    }

    public static void getProgramDetail(final String id, CustomCallback callback)
    {
        getInstance().getProgramDetail(id).enqueue(callback);
    }


}
