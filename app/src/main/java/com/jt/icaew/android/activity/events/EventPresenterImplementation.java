package com.jt.icaew.android.activity.events;

import com.jt.icaew.android.network.OnResponseListener;
import com.jt.icaew.android.network.event.EventManager;
import com.jt.icaew.android.network.event.EventResult;

/**
 * Created by Wandy on 7/11/2016.
 */
public class EventPresenterImplementation implements EventPresenter {

    private EventView eventView;

    public EventPresenterImplementation(EventView eventView)
    {
        this.eventView = eventView;
    }

    @Override
    public void getEvents() {
        EventManager.getEvent(new OnResponseListener() {
            @Override
            public void onSuccess(Object object) {
                EventResult eventResult = (EventResult) object;
                eventView.onFinishGetCountry(eventResult);
            }

            @Override
            public void onFailure(int responseCode, String message) {

            }
        });
    }
}
