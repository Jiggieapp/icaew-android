package com.jt.icaew.android.activity.events;

/**
 * Created by Wandy on 7/11/2016.
 */
public interface EventPresenter {

    interface GetEventListListener
    {
        void getEventList(final String countryId);
    }
}
