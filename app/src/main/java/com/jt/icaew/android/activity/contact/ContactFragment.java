package com.jt.icaew.android.activity.contact;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jt.icaew.android.R;
import com.jt.icaew.android.activity.BaseFragment;
import com.jt.icaew.android.activity.contact.adapter.ContactUsCountryAdapter;
import com.jt.icaew.android.activity.contact.detail.ContactDetailActivity;
import com.jt.icaew.android.activity.events.EventPresenterImplementation;
import com.jt.icaew.android.activity.events.EventView;
import com.jt.icaew.android.activity.events.adapter.EventCountryAdapter;
import com.jt.icaew.android.listener.OnViewSelectedListener;
import com.jt.icaew.android.network.event.CountryResult;
import com.jt.icaew.android.utils.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wandy on 6/30/2016.
 */
public class ContactFragment extends BaseFragment
        implements EventView.OnFinishGetCountryListener, OnViewSelectedListener{
    private final String TAG = ContactFragment.class.getSimpleName();
    private EventPresenterImplementation implementation = new EventPresenterImplementation();
    EventCountryAdapter adapter;

    @BindView(R.id.recycler_contact_us_country)
    RecyclerView recyclerCountry;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        implementation.setOnFinishGetCountryListener(this);
        implementation.getEvents();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    /*@Override
    public void onFinishGetContactCountry(ContactResult contactResult) {
        adapter = new ContactUsCountryAdapter(this.getContext(), contactResult.data, this);
        GridLayoutManager layoutManager = new GridLayoutManager(this.getContext(), 2);
        this.recyclerCountry.setLayoutManager(layoutManager);
        recyclerCountry.setAdapter(adapter);
    }*/

    @Override
    public void onFinishGetCountry(CountryResult countryResult) {
        adapter = new EventCountryAdapter(this.getContext(), countryResult.data, this);
        GridLayoutManager layoutManager = new GridLayoutManager(this.getContext(), 2);
        this.recyclerCountry.setLayoutManager(layoutManager);
        recyclerCountry.setAdapter(adapter);
    }

    @Override
    public void onViewSelected(CountryResult.Data data) {
        Bundle bundle = new Bundle();
        bundle.putLong(Constant.PARAM_COUNTRY_ID, data.id);
        bundle.putString(Constant.PARAM_COUNTRY_NAME, getResources().getString(R.string.icaew_office, data.name));
        getActivityController().redirect(ContactDetailActivity.class, bundle);
    }
}
