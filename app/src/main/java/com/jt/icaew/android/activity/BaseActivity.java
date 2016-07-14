package com.jt.icaew.android.activity;


import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.jt.icaew.android.R;

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

    protected Activity getActivity()
    {
        return getActivityController().getActivity();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected Bundle getBundle()
    {
        Bundle bundle = getIntent().getExtras().getBundle("bundle");
        return bundle;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.onBackPressed();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //super.overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
        //super.overridePendingTransition (R.anim.pull_in_left, R.anim.hold);
    }
}
