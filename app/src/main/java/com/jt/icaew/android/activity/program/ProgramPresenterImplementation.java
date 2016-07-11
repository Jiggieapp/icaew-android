package com.jt.icaew.android.activity.program;

import com.jt.icaew.android.network.OnResponseListener;
import com.jt.icaew.android.network.ProgramManager;

/**
 * Created by Wandy on 7/11/2016.
 */
public class ProgramPresenterImplementation implements ProgramPresenter {

    ProgramView programView;

    public ProgramPresenterImplementation(ProgramView programView)
    {
        this.programView = programView;
    }

    @Override
    public void getProgram() {
        ProgramManager.getProgram(
                new OnResponseListener() {
                    @Override
                    public void onSuccess(Object object) {
                        programView.onFinishGetProgram((ProgramResult) object);
                    }

                    @Override
                    public void onFailure(int responseCode, String message) {

                    }
                }
        );
    }
}
