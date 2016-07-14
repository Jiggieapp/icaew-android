package com.jt.icaew.android.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jt.icaew.android.R;

import butterknife.ButterKnife;

/**
 * Created by Wandy on 6/30/2016.
 */
public abstract class AbstractBaseActivity extends AppCompatActivity {

    private static final int THEME = R.style.AppCustomTheme;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //super.overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        super.setTheme(this.getThemeResource());
        super.onCreate(savedInstanceState);
        onCreate();

    }

    protected int getThemeResource() {
        return THEME;
    }
    public abstract void onCreate();
}
