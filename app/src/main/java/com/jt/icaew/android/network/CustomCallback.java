package com.jt.icaew.android.network;

/**
 * Created by Wandy on 7/11/2016.
 */


import java.net.SocketTimeoutException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Wandy on 2/12/2016.
 */
public abstract class CustomCallback implements Callback {
    //public Response response;
    private final String TAG = CustomCallback.class.getSimpleName();

    @Override
    public void onResponse(Call call, Response response) {
        final int responseCode = response.code();
        if(responseCode == 401) //error
        {

        }
        /*else if(responseCode == 400)
        {
            onCustomCallbackFailure();
        }*/
        else onCustomCallbackResponse(response);
        //this.response = response;
    }


    @Override
    public void onFailure(Call call, Throwable t) {
        String d = t.toString();
        /*if (t instanceof java.net.UnknownHostException) {
            onCustomCallbackFailure(App.getInstance().getResources().getString(R.string.no_internet_connection));
        } else if (t instanceof SocketTimeoutException) {
            onCustomCallbackFailure(App.getInstance().getResources().getString(R.string.socket_timeout_exception));
        } else {
            onCustomCallbackFailure(App.getInstance().getResources().getString(R.string.standard_error_message));
        }*/
    }

    public abstract void onCustomCallbackResponse(Response response);
    public abstract void onCustomCallbackFailure(String t);
    //public abstract void onNeedToRestart();
}

