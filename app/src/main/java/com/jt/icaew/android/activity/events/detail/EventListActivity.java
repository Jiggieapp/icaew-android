package com.jt.icaew.android.activity.events.detail;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.jt.icaew.android.R;
import com.jt.icaew.android.activity.BaseActivity;
import com.jt.icaew.android.activity.events.EventPresenterImplementation;
import com.jt.icaew.android.activity.events.EventView;
import com.jt.icaew.android.activity.events.adapter.EventDetailAdapter;
import com.jt.icaew.android.network.event.EventDetailResult;
import com.jt.icaew.android.utils.Constant;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventListActivity extends BaseActivity implements EventView.OnFinishGetEventListListener
{
    @BindView(R.id.recycler_events)
    RecyclerView recyclerEvents;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    EventPresenterImplementation implementation;
    EventDetailAdapter adapter;

    @Override
    public void onCreate() {
        setContentView(R.layout.activity_event_detail);
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
    public void onFinishGetEventListListener(EventDetailResult eventDetailResult) {
        ArrayList<EventDetailResult.Data> data = eventDetailResult.data;
        adapter = new EventDetailAdapter(this, data);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerEvents.setLayoutManager(layoutManager);
        recyclerEvents.setAdapter(adapter);
    }
}
