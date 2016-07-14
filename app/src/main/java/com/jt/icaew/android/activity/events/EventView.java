package com.jt.icaew.android.activity.events;

import com.jt.icaew.android.network.event.EventDetailResult;
import com.jt.icaew.android.network.event.EventResult;

/**
 * Created by Wandy on 7/11/2016.
 */
public interface EventView {
    interface OnFinishGetCountryListener
    {
        void onFinishGetCountry(EventResult eventResult);
    }

    interface OnFinishGetEventDetailListener
    {
        void onFinishGetEventDetailListener(EventDetailResult eventDetailResult);
    }
}
