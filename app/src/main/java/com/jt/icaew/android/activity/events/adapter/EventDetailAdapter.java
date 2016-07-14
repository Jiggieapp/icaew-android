package com.jt.icaew.android.activity.events.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jt.icaew.android.R;
import com.jt.icaew.android.network.event.EventDetailResult;
import com.jt.icaew.android.utils.Constant;
import com.jt.icaew.android.utils.Utils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wandy on 7/14/2016.
 */
public class EventDetailAdapter extends RecyclerView.Adapter<EventDetailAdapter.EventDetailViewHolder>
{
    private Context context;
    private ArrayList<EventDetailResult.Data> data;
    private final String TAG = EventDetailAdapter.class.getSimpleName();

    public EventDetailAdapter(Context context, ArrayList<EventDetailResult.Data> data)
    {
        this.context = context;
        this.data = data;
    }

    @Override
    public EventDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_event_detail, parent, false);
        ButterKnife.bind(this, view);
        return new EventDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventDetailViewHolder holder, int position) {
        holder.data = data.get(position);
        final String title = holder.data.title;
        final String description = holder.data.description;
        //final String initial = data.get(position).initial;

        holder.lblTitleProgram.setText(title);
        holder.lblDescriptionProgram.setText(description);
        holder.lblDescriptionProgram.setText(description);
        String date = getDate(holder.data.start_date);
        date = date.replace(" ", "\n");
        holder.lblInitialProgram.setText(date);
    }

    public String getDate(final String date)
    {
        try {
            final Date startDate = Constant.ISO8601_DATE_FORMAT_UTC.parse(date);
            return Utils.getTimeForEvent(startDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class EventDetailViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.lbl_title_program)
        TextView lblTitleProgram;

        @BindView(R.id.lbl_description_program)
        TextView lblDescriptionProgram;

        @BindView(R.id.lbl_initial_program)
        TextView lblInitialProgram;

        EventDetailResult.Data data;

        public EventDetailViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
