package com.jt.icaew.android.network.actions;

import com.jt.icaew.android.utils.Constant;

import retrofit2.Call;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by LTE on 7/15/2016.
 */
public interface LikeInterface {

    @PUT(Constant.URL_LIKE)
    Call<LikeResult> putLike(@Path("id") String id);

}
