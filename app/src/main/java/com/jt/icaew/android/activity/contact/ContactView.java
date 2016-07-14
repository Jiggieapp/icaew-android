package com.jt.icaew.android.activity.contact;

import com.jt.icaew.android.network.contact.ContactDetailResult;
import com.jt.icaew.android.network.contact.ContactResult;

/**
 * Created by Wandy on 7/12/2016.
 */
public interface ContactView {
    interface OnFinishGetContactCountryListener
    {
        void onFinishGetContactCountry(ContactResult contactResult);
    }

    interface OnFinishGetContactDetailListener
    {
        void onFinishGetContactDetail(ContactDetailResult contactDetailResult);
    }

}
