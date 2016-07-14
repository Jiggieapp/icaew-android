package com.jt.icaew.android.network.university;

import com.jt.icaew.android.utils.Constant;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by LTE on 7/13/2016.
 */
public interface UniversityInterface {
    @GET(Constant.URL_COUNTRY)
    Call<UniversityResult> getCountry();

    @GET(Constant.URL_UNIVERSITY)
    Call<UniversityListResult> getUniversityList(@Query("country_id") String country_id);
}
