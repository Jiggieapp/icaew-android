package com.jt.icaew.android.activity;


import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by Wandy on 6/30/2016.
 */
public abstract class BaseActivity extends AbstractBaseActivity {

    private ActivityController activityController;

    protected ActivityController getActivityController() {
        if (activityController == null)
            activityController = new ActivityController(this);
        return activityController;
    }

    protected AppCompatActivity getActivity()
    {
        return getActivityController().getActivity();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }
}
