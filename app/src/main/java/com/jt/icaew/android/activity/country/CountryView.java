package com.jt.icaew.android.activity.country;

import com.jt.icaew.android.network.event.CountryResult;

/**
 * Created by Wandy on 7/15/2016.
 */
public interface CountryView {
    interface OnFinishGetCountryListener
    {
        void onFinishGetCountry(CountryResult countryResult);
    }
}
