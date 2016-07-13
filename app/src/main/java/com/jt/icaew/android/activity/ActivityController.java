package com.jt.icaew.android.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

/**
 * Created by Wandy on 6/30/2016.
 */
public class ActivityController extends Activity{

    private Context context;
    Activity activity;

    public ActivityController(Activity a)
    {
        super();
        this.activity = a;
    }

    protected Activity getActivity()
    {
        context = activity.getApplicationContext();
        return activity;
    }

    protected Context getContext()
    {
        return context;
    }

    public void redirect(Class<? extends Activity> target)
    {
        Intent i = new Intent(getActivity().getApplicationContext()
                , target);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getActivity().getApplicationContext().startActivity(i);
    }

}
