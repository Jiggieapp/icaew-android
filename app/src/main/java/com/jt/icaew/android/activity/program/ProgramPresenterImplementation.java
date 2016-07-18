package com.jt.icaew.android.activity.program;

import android.util.Log;

import com.jt.icaew.android.network.OnResponseListener;
import com.jt.icaew.android.network.actions.LikeManager;
import com.jt.icaew.android.network.actions.LikeResult;
import com.jt.icaew.android.network.program.ProgramDetailResult;
import com.jt.icaew.android.network.program.ProgramManager;
import com.jt.icaew.android.network.program.ProgramResult;
import com.jt.icaew.android.utils.Utils;

/**
 * Created by Wandy on 7/11/2016.
 */
public class ProgramPresenterImplementation implements ProgramPresenter {

    ProgramView.OnFinishGetProgramListener onFinishGetProgramListener;
    ProgramView.OnFinishGetProgramDetailListener onFinishGetProgramDetailListener;
    ProgramView.OnLikeProgramListener onLikeProgramListener;

    public ProgramPresenterImplementation(ProgramView.OnFinishGetProgramListener onFinishGetProgramListener)
    {
        this.onFinishGetProgramListener = onFinishGetProgramListener;
    }

    public ProgramPresenterImplementation()
    {

    }

    /*public ProgramPresenterImplementation(ProgramView.OnFinishGetProgramDetailListener)
    {
        this.onFinishGetProgramDetailListener = onFinish
    }*/

    public void setOnFinishGetProgramDetailListener(ProgramView.OnFinishGetProgramDetailListener listener)
    {
        this.onFinishGetProgramDetailListener = listener;
    }

    @Override
    public void getProgram() {
        ProgramManager.getProgram(
                new OnResponseListener() {
                    @Override
                    public void onSuccess(Object object) {
                        ProgramResult result = (ProgramResult) object;
                        //header
                        if(result.data != null)
                        for(ProgramResult.Data temp : result.data)
                        {
                            if(temp.is_banner)
                            {
                                result.data.add(0, temp);
                                break;
                            }
                        }
                        //end of header
                        onFinishGetProgramListener.onFinishGetProgram(result);
                    }

                    @Override
                    public void onFailure( String message) {

                    }
                }
        );
    }

    @Override
    public void getProgramDetail(String programId) {
        ProgramManager.getProgramDetail(programId, new OnResponseListener() {
            @Override
            public void onSuccess(Object object) {
                if(onFinishGetProgramDetailListener != null)
                    onFinishGetProgramDetailListener.onFinishGetProgramDetail((ProgramDetailResult) object);
            }

            @Override
            public void onFailure( String message) {

            }
        });
    }

    public void setOnFinishLikeProgramListener(ProgramView.OnLikeProgramListener listener)
    {
        this.onLikeProgramListener = listener;
    }

    @Override
    public void postLike(String programId) {
            LikeManager.putLike(programId, new OnResponseListener() {
                @Override
                public void onSuccess(Object object) {
                    onLikeProgramListener.onLikeProgram((LikeResult) object);
                }

                @Override
                public void onFailure( String message) {
                    Log.d("failure", "fail");
                }
            });

    }
}
