package com.jt.icaew.android.activity;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Wandy on 6/30/2016.
 */
public class ActivityController extends Activity{

    private Context context;
    AppCompatActivity activity;
    public ActivityController(AppCompatActivity a)
    {
        super();
        this.activity = a;
    }

    protected AppCompatActivity getActivity()
    {
        context = activity.getApplicationContext();
        return activity;
    }

    protected Context getContext()
    {
        return context;
    }



}
