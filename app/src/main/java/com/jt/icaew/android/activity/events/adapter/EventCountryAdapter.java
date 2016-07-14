package com.jt.icaew.android.activity.events.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jt.icaew.android.R;
import com.jt.icaew.android.listener.OnViewSelectedListener;
import com.jt.icaew.android.network.event.CountryResult;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wandy on 7/11/2016.
 */
public class EventCountryAdapter extends RecyclerView.Adapter<EventCountryAdapter.EventCountryViewHolder>{

    Context context;
    ArrayList<CountryResult.Data> data;
    OnViewSelectedListener onViewSelectedListener;

    public EventCountryAdapter(Context context, ArrayList<CountryResult.Data> data, OnViewSelectedListener listener)
    {
        this.context = context;
        this.data = data;
        this.onViewSelectedListener = listener;
    }

    @Override
    public EventCountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_event_country, parent, false);
        return new EventCountryViewHolder(view, onViewSelectedListener);
    }


    @Override
    public void onBindViewHolder(EventCountryViewHolder holder, int position) {
        holder.data = data.get(position);
        final String name = holder.data.name;
        final String url = holder.data.image;
        holder.lblCountryName.setText(name);

        Glide.with(context).load(url).into(holder.imageCountry);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class EventCountryViewHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener
    {
        @BindView(R.id.image_country_flag)
        ImageView imageCountry;

        @BindView(R.id.lbl_country_name)
        TextView lblCountryName;

        CountryResult.Data data;
        OnViewSelectedListener onViewSelectedListener;

        public EventCountryViewHolder(View itemView, OnViewSelectedListener listener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.onViewSelectedListener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(onViewSelectedListener != null)
                onViewSelectedListener.onViewSelected(data);
        }
    }


}
