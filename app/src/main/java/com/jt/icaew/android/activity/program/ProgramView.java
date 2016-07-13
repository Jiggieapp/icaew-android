package com.jt.icaew.android.activity.program;

import com.jt.icaew.android.network.program.ProgramDetailResult;
import com.jt.icaew.android.network.program.ProgramResult;

/**
 * Created by Wandy on 7/11/2016.
 */
public interface ProgramView {
    interface OnFinishGetProgramListener
    {
        void onFinishGetProgram(ProgramResult programResult);
    }

    interface OnFinishGetProgramDetailListener
    {
        void onFinishGetProgramDetail(ProgramDetailResult programDetailResult);
    }
}
