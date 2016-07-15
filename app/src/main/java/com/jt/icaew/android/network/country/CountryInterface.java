package com.jt.icaew.android.network.country;

import com.jt.icaew.android.network.event.CountryResult;
import com.jt.icaew.android.utils.Constant;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Wandy on 7/15/2016.
 */
public interface CountryInterface {
    @GET(Constant.URL_COUNTRY)
    Call<CountryResult> getCountry();
}
