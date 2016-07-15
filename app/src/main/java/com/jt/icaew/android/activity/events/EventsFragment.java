package com.jt.icaew.android.activity.events;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jt.icaew.android.R;
import com.jt.icaew.android.activity.BaseFragment;
import com.jt.icaew.android.activity.country.CountryView;
import com.jt.icaew.android.activity.events.adapter.CountryAdapter;
import com.jt.icaew.android.activity.events.detail.EventListActivity;
import com.jt.icaew.android.listener.OnViewSelectedListener;
import com.jt.icaew.android.network.country.CountryPresenterImplementation;
import com.jt.icaew.android.network.event.CountryResult;
import com.jt.icaew.android.utils.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wandy on 6/30/2016.
 */
public class EventsFragment extends BaseFragment implements CountryView.OnFinishGetCountryListener, OnViewSelectedListener {
    private CountryPresenterImplementation implementation;
    private final String TAG = EventsFragment.class.getSimpleName();
    private CountryAdapter adapter;

    @BindView(R.id.recycler_event_country)
    RecyclerView recylerCountry;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        implementation = new CountryPresenterImplementation();
        implementation.setOnFinishGetCountryListener(this);
        implementation.getCountries();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onFinishGetCountry(CountryResult countryResult) {
        adapter = new CountryAdapter(this.getContext(), countryResult.data, this);
        GridLayoutManager layoutManager = new GridLayoutManager(this.getContext(), 2);
        this.recylerCountry.setLayoutManager(layoutManager);
        recylerCountry.setAdapter(adapter);
    }


    @Override
    public void onViewSelected(CountryResult.Data data) {
        Bundle bundle = new Bundle();
        bundle.putString(Constant.PARAM_COUNTRY_ID, data.id + "");
        bundle.putString(Constant.PARAM_TOOLBAR_TITLE, getResources().getString(R.string.events_in, data.name));
        getActivityController().redirect(EventListActivity.class, bundle);
    }
}
