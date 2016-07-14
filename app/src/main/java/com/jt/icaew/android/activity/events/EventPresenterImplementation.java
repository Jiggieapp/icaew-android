package com.jt.icaew.android.activity.events;

import com.jt.icaew.android.network.OnResponseListener;
import com.jt.icaew.android.network.event.EventDetailResult;
import com.jt.icaew.android.network.event.EventManager;
import com.jt.icaew.android.network.event.CountryResult;

/**
 * Created by Wandy on 7/11/2016.
 */
public class EventPresenterImplementation implements EventPresenter.GetEvents, EventPresenter.GetEventDetailListener {

    private EventView.OnFinishGetCountryListener onFinishgetCountryListener;
    private EventView.OnFinishGetEventDetailListener onFinishGetEventDetailListener;

    public EventPresenterImplementation()
    {

    }

    public EventPresenterImplementation(EventView.OnFinishGetCountryListener onFinishgetCountryListener)
    {
        this.onFinishgetCountryListener = onFinishgetCountryListener;
    }

    @Override
    public void getEvents() {
        EventManager.getEvent(new OnResponseListener() {
            @Override
            public void onSuccess(Object object) {
                CountryResult countryResult = (CountryResult) object;
                onFinishgetCountryListener.onFinishGetCountry(countryResult);
            }

            @Override
            public void onFailure(int responseCode, String message) {

            }
        });
    }

    @Override
    public void getEventDetail(final String countryId) {
        EventManager.getEventDetail(countryId, new OnResponseListener() {
            @Override
            public void onSuccess(Object object) {
                EventDetailResult result = (EventDetailResult) object;
                onFinishGetEventDetailListener.onFinishGetEventDetailListener(result);
            }

            @Override
            public void onFailure(int responseCode, String message) {

            }
        });
    }

    public void setOnFinishGetCountryListener(EventView.OnFinishGetCountryListener listener)
    {
        this.onFinishgetCountryListener = listener;
    }

    public void setOnFinishGetEventDetailListener(EventView.OnFinishGetEventDetailListener listener)
    {
        this.onFinishGetEventDetailListener = listener;
    }
}
