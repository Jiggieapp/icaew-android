package com.jt.icaew.android.activity.events;

/**
 * Created by Wandy on 7/11/2016.
 */
public interface EventPresenter {

    interface GetEvents
    {
        void getEvents();
    }

    interface GetEventDetailListener
    {
        void getEventDetail(final String countryId);
    }
}
