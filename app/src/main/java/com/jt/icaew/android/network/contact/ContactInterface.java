package com.jt.icaew.android.network.contact;

import com.jt.icaew.android.utils.Constant;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Wandy on 7/12/2016.
 */
public interface ContactInterface {

    @GET(Constant.URL_CONTACT)
    Call<ContactResult> getContactUsCountry();

    @GET(Constant.URL_CONTACT_DETAIL)
    Call<ContactDetailResult> getContactUsDetail(@Path("id") String id);
}
