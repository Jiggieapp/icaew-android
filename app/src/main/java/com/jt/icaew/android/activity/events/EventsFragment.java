package com.jt.icaew.android.activity.events;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.jt.icaew.android.R;
import com.jt.icaew.android.activity.BaseFragment;
import com.jt.icaew.android.activity.contact.adapter.ContactUsCountryAdapter;
import com.jt.icaew.android.activity.events.detail.EventDetailActivity;
import com.jt.icaew.android.listener.OnViewSelectedListener;
import com.jt.icaew.android.network.contact.ContactResult;
import com.jt.icaew.android.network.event.EventResult;
import com.jt.icaew.android.activity.events.adapter.EventCountryAdapter;
import com.jt.icaew.android.utils.Constant;
import com.jt.icaew.android.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wandy on 6/30/2016.
 */
public class EventsFragment extends BaseFragment implements EventView.OnFinishGetCountryListener, OnViewSelectedListener {
    private EventPresenterImplementation implementation;
    private final String TAG = EventsFragment.class.getSimpleName();
    private EventCountryAdapter adapter;

    @BindView(R.id.recycler_event_country)
    RecyclerView recylerCountry;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        implementation = new EventPresenterImplementation();
        implementation.setOnFinishGetCountryListener(this);
        implementation.getEvents();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onFinishGetCountry(EventResult eventResult) {
        adapter = new EventCountryAdapter(this.getContext(), eventResult.data, this);
        GridLayoutManager layoutManager = new GridLayoutManager(this.getContext(), 2);
        this.recylerCountry.setLayoutManager(layoutManager);
        recylerCountry.setAdapter(adapter);
    }


    @Override
    public void onViewSelected(EventResult.Data data) {
        Bundle bundle = new Bundle();
        Utils.d(TAG, "data " + data.id);
        bundle.putString(Constant.PARAM_COUNTRY_ID, data.id + "");
        bundle.putString(Constant.PARAM_TOOLBAR_TITLE, getResources().getString(R.string.events_in, data.name));
        getActivityController().redirect(EventDetailActivity.class, bundle);
    }
}
