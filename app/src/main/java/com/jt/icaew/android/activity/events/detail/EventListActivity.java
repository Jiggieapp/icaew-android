package com.jt.icaew.android.activity.events.detail;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.jt.icaew.android.R;
import com.jt.icaew.android.activity.BaseActivity;
import com.jt.icaew.android.activity.events.EventPresenterImplementation;
import com.jt.icaew.android.activity.events.EventView;
import com.jt.icaew.android.activity.events.adapter.EventListAdapter;
import com.jt.icaew.android.network.event.EventListResult;
import com.jt.icaew.android.utils.Constant;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventListActivity extends BaseActivity
        implements EventView.OnFinishGetEventListListener, EventListAdapter.OnEventListSelectedListener
{
    @BindView(R.id.recycler_events)
    RecyclerView recyclerEvents;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    EventPresenterImplementation implementation;
    EventListAdapter adapter;

    @Override
    public void onCreate() {
        setContentView(R.layout.activity_event_list);
        ButterKnife.bind(this);

        Bundle bundle = getBundle();
        if(toolbar != null)
        {
            super.setSupportActionBar(toolbar);
            super.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            super.getSupportActionBar().setHomeButtonEnabled(true);
            if(bundle != null)
            {
                super.getSupportActionBar().setTitle(bundle.getString(Constant.PARAM_TOOLBAR_TITLE));
            }
        }
        implementation = new EventPresenterImplementation();
        implementation.setOnFinishGetEventListListener(this);

        if (bundle != null) {
            final String id = bundle.getString(Constant.PARAM_COUNTRY_ID);
            implementation.getEventList(id);
        }
    }

    @Override
    public void onFinishGetEventListListener(EventListResult eventListResult) {
        ArrayList<EventListResult.Data> data = eventListResult.data;
        adapter = new EventListAdapter(this, data, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerEvents.setLayoutManager(layoutManager);
        recyclerEvents.setAdapter(adapter);
    }

    @Override
    public void onEventListSelected(EventListResult.Data data) {
        Bundle bundle = new Bundle();
        bundle.putString(Constant.PARAM_EVENT_DESCRIPTION, data.description);
        bundle.putString(Constant.PARAM_EVENT_START_DATE, data.start_date);
        bundle.putString(Constant.PARAM_EVENT_TITLE, data.title);
        bundle.putString(Constant.PARAM_EVENT_SUMMARY, data.summary);

        getActivityController().redirect(EventDetailActivity.class, bundle);
    }
}
