package com.jt.icaew.android.network.event;

import com.jt.icaew.android.utils.Constant;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Wandy on 7/11/2016.
 */
public interface EventInterface {
    @GET(Constant.URL_COUNTRY)
    Call<EventResult> getCountry();
}
