package com.jt.icaew.android.activity.contact;

import com.jt.icaew.android.network.OnResponseListener;
import com.jt.icaew.android.network.contact.ContactDetailResult;
import com.jt.icaew.android.network.contact.ContactManager;
import com.jt.icaew.android.network.contact.ContactResult;
import com.jt.icaew.android.utils.Utils;

/**
 * Created by Wandy on 7/12/2016.
 */
public class ContactPresenterImplementation implements ContactPresenter {

    private ContactView.OnFinishGetContactCountryListener contactListener;
    private ContactView.OnFinishGetContactDetailListener contactDetailListener;

    public void setOnFinishGetContactCountryListener(ContactView.OnFinishGetContactCountryListener listener)
    {
        this.contactListener = listener;
    }

    public void setOnFinishGetContactDetailListener(ContactView.OnFinishGetContactDetailListener listener)
    {
        this.contactDetailListener = listener;
    }


    @Override
    public void getContactCountry() {
        ContactManager.getContactUsCountry(new OnResponseListener() {
            @Override
            public void onSuccess(Object object) {
                contactListener.onFinishGetContactCountry((ContactResult) object);
            }

            @Override
            public void onFailure(int responseCode, String message) {

            }
        });
    }

    @Override
    public void getContactUsDetail(final String id) {
        ContactManager.getContactUsDetail(id, new OnResponseListener() {
            @Override
            public void onSuccess(Object object) {
                ContactDetailResult result = (ContactDetailResult) object;
                contactDetailListener.onFinishGetContactDetail(result);
            }

            @Override
            public void onFailure(int responseCode, String message) {

            }
        });
    }


}
