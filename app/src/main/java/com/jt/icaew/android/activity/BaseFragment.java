package com.jt.icaew.android.activity;

import android.support.v4.app.Fragment;

/**
 * Created by Wandy on 7/12/2016.
 */
public class BaseFragment extends Fragment {

    private ActivityController activityController;
    public ActivityController getActivityController()
    {
        if(activityController == null)
            activityController = new ActivityController(getActivity());
        return activityController;
    }


}
