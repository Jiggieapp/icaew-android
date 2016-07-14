package com.jt.icaew.android.activity.contact.detail;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

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
        implementation.getContactUsDetail(countryId + "");
    }

    @Override
    public void onFinishGetContactDetail(ContactDetailResult contactDetailResult) {
        final ContactDetailResult.Data dataa = contactDetailResult.data.get(0);
        lblUniversityAddress.setText(dataa.getAddress());
        lblUniversityEmail.setText(getResources().getString(R.string.email_university, dataa.getEmail()));
        lblUniversityPhone.setText(getResources().getString(R.string.phone_university, dataa.getTelp()));
        lblUniversityFacebook.setText(getResources().getString(R.string.facebook_university, dataa.getFacebook()));
        lblUniversityWebsite.setText(getResources().getString(R.string.website_university, dataa.getWebsite()));
    }

    private Context getContext()
    {
        return getActivityController().getContext();
    }

}
