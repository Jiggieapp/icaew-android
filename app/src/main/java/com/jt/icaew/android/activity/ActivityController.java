package com.jt.icaew.android.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
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

    public Context getContext()
    {
        return context;
    }

    public void redirect(Class<? extends Activity> target, Bundle bundle)
    {
        Intent i = new Intent(getActivity().getApplicationContext()
                , target);
        i.putExtra("bundle", bundle);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getActivity().getApplicationContext().startActivity(i);
    }

    /*public void redirect(Class<? extends Activity> target, Parcelable parcelable)
    {

    }*/

    public void redirect(Class<? extends Activity> target)
    {
        redirect(target, null);
    }

}
