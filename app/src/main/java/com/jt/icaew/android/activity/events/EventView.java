package com.jt.icaew.android.activity.events;

import com.jt.icaew.android.network.event.EventDetailResult;
import com.jt.icaew.android.network.event.CountryResult;

/**
 * Created by Wandy on 7/11/2016.
 */
public interface EventView {
    interface OnFinishGetCountryListener
    {
        void onFinishGetCountry(CountryResult countryResult);
    }

    interface OnFinishGetEventDetailListener
    {
        void onFinishGetEventDetailListener(EventDetailResult eventDetailResult);
    }
}
