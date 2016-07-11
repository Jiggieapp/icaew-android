package com.jt.icaew.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jt.icaew.android.activity.MainActivity;
import com.jt.icaew.android.utils.Utils;

public class SplashActivity extends AppCompatActivity {

    private final String TAG = SplashActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_splash);

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        Utils.d(TAG, "splash activity");
        finish();
    }
}
