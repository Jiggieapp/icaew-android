package com.jt.icaew.android.activity.contact.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jt.icaew.android.R;
import com.jt.icaew.android.network.contact.ContactResult;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wandy on 7/12/2016.
 */
public class ContactUsCountryAdapter extends RecyclerView.Adapter<ContactUsCountryAdapter.ContactUsCountryViewHolder> {

    Context context;
    ArrayList<ContactResult.Data> data;
    OnViewSelectedListener onViewSelectedListener;

    public ContactUsCountryAdapter(Context context, ArrayList<ContactResult.Data> data, OnViewSelectedListener listener)
    {
        this.context = context;
        this.data = data;
        this.onViewSelectedListener = listener;
    }

    @Override
    public ContactUsCountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_contact_us_country, parent, false);
        return new ContactUsCountryViewHolder(view, onViewSelectedListener);
    }

    @Override
    public void onBindViewHolder(ContactUsCountryViewHolder holder, int position) {
        holder.data = data.get(position);
        final String name = data.get(position).country_name;
        final String url = data.get(position).image;
        holder.lblContactUsCountryName.setText(name);

        Glide.with(context).load(url).into(holder.imageCountry);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ContactUsCountryViewHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener
    {
        @BindView(R.id.image_contact_us_country_flag)
        ImageView imageCountry;

        @BindView(R.id.lbl_contact_us_country_name)
        TextView lblContactUsCountryName;

        OnViewSelectedListener onViewSelectedListener;
        ContactResult.Data data;

        public ContactUsCountryViewHolder(View itemView, OnViewSelectedListener onViewSelectedListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.onViewSelectedListener = onViewSelectedListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(onViewSelectedListener != null)
                onViewSelectedListener.onViewSelected(data);
        }
    }

    public interface OnViewSelectedListener
    {
        void onViewSelected(final ContactResult.Data data);
    }

}
