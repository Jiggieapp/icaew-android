package com.jt.icaew.android.activity.events;

import com.jt.icaew.android.network.OnResponseListener;
import com.jt.icaew.android.network.event.EventListResult;
import com.jt.icaew.android.network.event.EventManager;

/**
 * Created by Wandy on 7/11/2016.
 */
public class EventPresenterImplementation implements EventPresenter.GetEventListListener {

    //private EventView.OnFinishGetCountryListener onFinishgetCountryListener;
    private EventView.OnFinishGetEventListListener onFinishGetEventListListener;

    public EventPresenterImplementation()
    {

    }

   /* public EventPresenterImplementation(EventView.OnFinishGetCountryListener onFinishgetCountryListener)
    {
        this.onFinishgetCountryListener = onFinishgetCountryListener;
    }*/

    @Override
    public void getEventList(final String countryId) {
        EventManager.getEventDetail(countryId, new OnResponseListener() {
            @Override
            public void onSuccess(Object object) {
                EventListResult result = (EventListResult) object;
                onFinishGetEventListListener.onFinishGetEventListListener(result);
            }

            @Override
            public void onFailure( String message) {

            }
        });
    }

    public void setOnFinishGetEventListListener(EventView.OnFinishGetEventListListener listener)
    {
        this.onFinishGetEventListListener = listener;
    }
}
