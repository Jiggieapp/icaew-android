package com.jt.icaew.android.activity.contact.detail;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jt.icaew.android.R;
import com.jt.icaew.android.activity.BaseActivity;
import com.jt.icaew.android.activity.contact.ContactPresenterImplementation;
import com.jt.icaew.android.activity.contact.ContactView;
import com.jt.icaew.android.network.contact.ContactDetailResult;
import com.jt.icaew.android.utils.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wandy on 7/13/2016.
 */
public class ContactDetailActivity extends BaseActivity implements ContactView.OnFinishGetContactDetailListener{

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.lbl_university_address)
    TextView lblUniversityAddress;

    @BindView(R.id.lbl_university_email)
    TextView lblUniversityEmail;

    @BindView(R.id.lbl_university_facebook)
    TextView lblUniversityFacebook;

    @BindView(R.id.lbl_university_name)
    TextView lblUniversityName;

    @BindView(R.id.lbl_university_phone)
    TextView lblUniversityPhone;

    @BindView(R.id.lbl_university_website)
    TextView lblUniversityWebsite;

    @BindView(R.id.img_banner)
    ImageView imgBanner;

    private final String TAG = ContactDetailActivity.class.getSimpleName();
    ContactPresenterImplementation implementation;

    long countryId;

    @Override
    public void onCreate() {
        setContentView(R.layout.activity_contact_detail);
        ButterKnife.bind(this);
        Bundle bundle = getBundle();

        if(toolbar != null)
        {
            setSupportActionBar(toolbar);
            if(bundle != null)
            {
                countryId = bundle.getLong(Constant.PARAM_COUNTRY_ID);
                final String countryName = bundle.getString(Constant.PARAM_COUNTRY_NAME);
                getSupportActionBar().setTitle(countryName);
            }

            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        implementation = new ContactPresenterImplementation();
        implementation.setOnFinishGetContactDetailListener(this);
        showProgressDialog();
        implementation.getContactUsDetail(countryId + "");
    }

    @Override
    public void onFinishGetContactDetail(ContactDetailResult contactDetailResult) {
        final ContactDetailResult.Data data = contactDetailResult.data.get(0);
        if(data.getImage().isEmpty())
        {
            Glide.with(this).load(R.drawable.default_banner_bg).into(imgBanner);
        }
        else
        {
            Glide.with(this).load(data.getImage()).into(imgBanner);
        }
        lblUniversityName.setText(getResources().getString(R.string.icaew) + " " + data.country_name);
        lblUniversityAddress.setText(data.getAddress());
        lblUniversityEmail.setText(data.getEmail());
        lblUniversityPhone.setText(data.getTelp());
        lblUniversityFacebook.setText(data.getFacebook());
        lblUniversityWebsite.setText(data.getWebsite());
        dismissProgressDialog();
    }

    @Override
    public void onFailGetContactDetail(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        dismissProgressDialog();
        finish();
    }

    private Context getContext()
    {
        return getActivityController().getContext();
    }

    ProgressDialog progressDialog;
    private void showProgressDialog()
    {
        progressDialog = ProgressDialog.show(this, "", getResources().getString(R.string.please_wait));
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    private void dismissProgressDialog()
    {
        if(progressDialog != null && progressDialog.isShowing())
            progressDialog.dismiss();
    }

}
