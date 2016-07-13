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

    public ContactUsCountryAdapter(Context context, ArrayList<ContactResult.Data> data)
    {
        this.context = context;
        this.data = data;
    }

    @Override
    public ContactUsCountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_contact_us_country, parent, false);
        return new ContactUsCountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactUsCountryViewHolder holder, int position) {
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
    {
        @BindView(R.id.image_contact_us_country_flag)
        ImageView imageCountry;

        @BindView(R.id.lbl_contact_us_country_name)
        TextView lblContactUsCountryName;

        public ContactUsCountryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
