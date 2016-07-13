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
import com.jt.icaew.android.network.event.EventResult;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wandy on 7/11/2016.
 */
public class EventCountryAdapter extends RecyclerView.Adapter<EventCountryAdapter.EventCountryViewHolder>{

    Context context;
    ArrayList<EventResult.Data> data;

    public EventCountryAdapter(Context context, ArrayList<EventResult.Data> data)
    {
        this.context = context;
        this.data = data;
    }

    @Override
    public EventCountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_event_country, parent, false);
        return new EventCountryViewHolder(view);
    }


    @Override
    public void onBindViewHolder(EventCountryViewHolder holder, int position) {
        final String name = data.get(position).name;
        final String url = data.get(position).image;
        holder.lblCountryName.setText(name);

        Glide.with(context).load(url).into(holder.imageCountry);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class EventCountryViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.image_country_flag)
        ImageView imageCountry;

        @BindView(R.id.lbl_country_name)
        TextView lblCountryName;

        public EventCountryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}