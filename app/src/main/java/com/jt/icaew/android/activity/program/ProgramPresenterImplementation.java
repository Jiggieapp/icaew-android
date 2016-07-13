package com.jt.icaew.android.activity.program;

import com.jt.icaew.android.network.OnResponseListener;
import com.jt.icaew.android.network.program.ProgramDetailResult;
import com.jt.icaew.android.network.program.ProgramManager;
import com.jt.icaew.android.network.program.ProgramResult;

/**
 * Created by Wandy on 7/11/2016.
 */
public class ProgramPresenterImplementation implements ProgramPresenter {

    ProgramView.OnFinishGetProgramListener onFinishGetProgramListener;
    ProgramView.OnFinishGetProgramDetailListener onFinishGetProgramDetailListener;

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
                        onFinishGetProgramListener.onFinishGetProgram((ProgramResult) object);
                    }

                    @Override
                    public void onFailure(int responseCode, String message) {

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
            public void onFailure(int responseCode, String message) {

            }
        });
    }
}
