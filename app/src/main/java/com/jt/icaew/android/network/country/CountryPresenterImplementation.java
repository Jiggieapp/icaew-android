package com.jt.icaew.android.network.country;

import com.jt.icaew.android.activity.country.CountryView;
import com.jt.icaew.android.activity.events.EventView;
import com.jt.icaew.android.network.OnResponseListener;
import com.jt.icaew.android.network.event.CountryResult;

/**
 * Created by Wandy on 7/15/2016.
 */
public class CountryPresenterImplementation implements CountryPresenter{

    private CountryView.OnFinishGetCountryListener onFinishGetCountryListener;

    public void setOnFinishGetCountryListener(CountryView.OnFinishGetCountryListener listener)
    {
        this.onFinishGetCountryListener = listener;
    }

    public void getCountries()
    {
        CountryManager.getCountry(new OnResponseListener() {
            @Override
            public void onSuccess(Object object) {
                CountryResult result = (CountryResult) object;
                onFinishGetCountryListener.onFinishGetCountry(result);
            }

            @Override
            public void onFailure(int responseCode, String message) {

            }
        });
    }
}
