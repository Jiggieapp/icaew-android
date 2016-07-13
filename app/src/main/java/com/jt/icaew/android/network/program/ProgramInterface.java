package com.jt.icaew.android.network.program;

import com.jt.icaew.android.utils.Constant;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Wandy on 7/11/2016.
 */
public interface ProgramInterface {

    @GET(Constant.URL_PROGRAM)
    Call<ProgramResult> getProgram();

    @GET(Constant.URL_PROGRAM_DETAIL)
    Call<ProgramDetailResult> getProgramDetail(@Path("id") String id);

}
