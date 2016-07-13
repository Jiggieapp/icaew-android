package com.jt.icaew.android.network.about;

import com.jt.icaew.android.utils.Constant;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Wandy on 7/12/2016.
 */
public interface AboutInterface {
    @GET(Constant.URL_ABOUT)
    Call<AboutResult> getAbout();
}
