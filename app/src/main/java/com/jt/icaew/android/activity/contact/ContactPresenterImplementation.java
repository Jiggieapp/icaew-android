package com.jt.icaew.android.activity.contact;

import com.jt.icaew.android.network.OnResponseListener;
import com.jt.icaew.android.network.contact.ContactManager;
import com.jt.icaew.android.network.contact.ContactResult;
import com.jt.icaew.android.utils.Utils;

/**
 * Created by Wandy on 7/12/2016.
 */
public class ContactPresenterImplementation implements ContactPresenter {

    private ContactView contactView;
    public ContactPresenterImplementation(ContactView contactView)
    {
        this.contactView = contactView;
    }

    @Override
    public void getContactCountry() {
        ContactManager.getContactUsCountry(new OnResponseListener() {
            @Override
            public void onSuccess(Object object) {
                contactView.onFinishGetContactCountry((ContactResult) object);
            }

            @Override
            public void onFailure(int responseCode, String message) {

            }
        });
    }
}
