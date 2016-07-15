package com.jt.icaew.android.network.event;

import com.jt.icaew.android.utils.Constant;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Wandy on 7/11/2016.
 */
public interface EventInterface {
    @GET(Constant.URL_EVENT_DETAIL)
    Call<EventDetailResult> getEventDetail(@Query("country_id") String id);
}
