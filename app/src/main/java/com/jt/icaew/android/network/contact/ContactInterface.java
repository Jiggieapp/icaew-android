package com.jt.icaew.android.network.contact;

import com.jt.icaew.android.utils.Constant;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Wandy on 7/12/2016.
 */
public interface ContactInterface {

    /*@GET(Constant.URL_CONTACT)
    Call<ContactResult> getContactUsCountry();*/

    @GET(Constant.URL_CONTACT)
    Call<ContactDetailResult> getContactUsDetail(@Query("country_id") String id);
}
