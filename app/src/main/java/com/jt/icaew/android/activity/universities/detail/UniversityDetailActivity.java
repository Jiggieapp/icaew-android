package com.jt.icaew.android.activity.universities.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.jt.icaew.android.R;
import com.jt.icaew.android.activity.BaseActivity;
import com.jt.icaew.android.activity.universities.UniversityPresenterImplementation;
import com.jt.icaew.android.activity.universities.UniversityView;
import com.jt.icaew.android.network.university.UniversityListResult;
import com.jt.icaew.android.utils.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LTE on 7/13/2016.
 */
public class UniversityDetailActivity extends BaseActivity implements UniversityView.onFinishGetUniversityDetailListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.lbl_program_description)
    TextView lblProgramDescription;
    @BindView(R.id.lbl_address)
    TextView lblAddress;
    @BindView(R.id.lbl_phone)
    TextView lblPhone;
    @BindView(R.id.lbl_email)
    TextView lblEmail;
    @BindView(R.id.lbl_address_fill)
    TextView lblAddressFill;
    @BindView(R.id.lbl_phone_fill)
    TextView lblPhoneFill;
    @BindView(R.id.lbl_email_fill)
    TextView lblEmailFill;

    private UniversityPresenterImplementation implementation;

    @Override
    public void onCreate() {
        setContentView(R.layout.activity_university_detail);
        ButterKnife.bind(this);
        implementation = new UniversityPresenterImplementation();
        implementation.setOnFinishGetUniversityDetailListener(this);

        /*setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getIntent().getStringExtra(Constant.COUNTRY_NAME));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null) {
            super.setSupportActionBar(toolbar);
            final String programName = getIntent().getStringExtra(Constant.COUNTRY_NAME);

            getSupportActionBar().setTitle(programName.toUpperCase());
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        implementation.getUniversityDetail(getIntent().getStringExtra(Constant.COUNTRY_ID));
    }

    @Override
    public void onFinishGetUniversityDetail(UniversityListResult universityListResult) {
        UniversityListResult.Data data = universityListResult.getData().get(0);

        lblProgramDescription.setText(getResources().getString(R.string.app_name));
        if (data.getEmail() != null && !data.getEmail().isEmpty()) {
            lblEmailFill.setText(data.getEmail());
        }
        if (data.getPhone() != null && !data.getPhone().isEmpty()) {
            lblPhoneFill.setText(data.getPhone());
        }
        if (data.getAddress() != null && !data.getAddress().isEmpty()) {
            lblAddressFill.setText(data.getAddress());
        }
    }

    @Override
    public void onFailureGetUniversity(String message) {
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return true;
    }
}
