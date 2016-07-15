package com.jt.icaew.android.activity.events.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jt.icaew.android.R;
import com.jt.icaew.android.network.event.EventListResult;
import com.jt.icaew.android.utils.Utils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wandy on 7/14/2016.
 */
public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.EventListViewHolder>
{
    private Context context;
    private ArrayList<EventListResult.Data> data;
    private final String TAG = EventListAdapter.class.getSimpleName();
    OnEventListSelectedListener onViewSelectedListener;

    public EventListAdapter(Context context, ArrayList<EventListResult.Data> data, OnEventListSelectedListener listener)
    {
        this.context = context;
        this.data = data;
        this.onViewSelectedListener = listener;
    }

    @Override
    public EventListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_event_detail, parent, false);
        ButterKnife.bind(this, view);
        return new EventListViewHolder(view, onViewSelectedListener);
    }

    @Override
    public void onBindViewHolder(EventListViewHolder holder, int position) {
        holder.data = data.get(position);
        final String title = holder.data.title;
        final String description = holder.data.description;
        //final String initial = data.get(position).initial;

        holder.lblTitleProgram.setText(title);
        holder.lblDescriptionProgram.setText(description);
        String date = Utils.getDate(holder.data.start_date);
        date = date.replace(" ", "\n");
        holder.lblInitialProgram.setText(date);
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    static class EventListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        @BindView(R.id.lbl_title_program)
        TextView lblTitleProgram;

        @BindView(R.id.lbl_description_program)
        TextView lblDescriptionProgram;

        @BindView(R.id.lbl_initial_program)
        TextView lblInitialProgram;

        EventListResult.Data data;
        OnEventListSelectedListener onViewSelectedListener;

        public EventListViewHolder(View itemView, OnEventListSelectedListener listener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.onViewSelectedListener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(onViewSelectedListener != null)
                onViewSelectedListener.onEventListSelected(data);
        }
    }

    public interface OnEventListSelectedListener
    {
        void onEventListSelected(EventListResult.Data data);
    }
}
