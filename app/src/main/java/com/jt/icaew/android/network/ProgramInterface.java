package com.jt.icaew.android.network;

import com.jt.icaew.android.activity.program.ProgramResult;
import com.jt.icaew.android.utils.Constant;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Wandy on 7/11/2016.
 */
public interface ProgramInterface {

    @GET(Constant.URL_PROGRAM)
    Call<ProgramResult> getProgram();

}
