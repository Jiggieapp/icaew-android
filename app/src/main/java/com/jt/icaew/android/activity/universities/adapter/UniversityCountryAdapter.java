package com.jt.icaew.android.activity.universities.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jt.icaew.android.R;
import com.jt.icaew.android.network.university.UniversityResult;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LTE on 7/13/2016.
 */
public class UniversityCountryAdapter extends RecyclerView.Adapter<UniversityCountryAdapter.UniversityCountryViewHolder>{

    Context context;
    ArrayList<UniversityResult.Data> data;
    OnCountrySelectedListener onCountrySelectedListener;

    public UniversityCountryAdapter(Context context, ArrayList<UniversityResult.Data> data, OnCountrySelectedListener onCountrySelectedListener)
    {
        this.context = context;
        this.data = data;
        this.onCountrySelectedListener = onCountrySelectedListener;
    }

    @Override
    public UniversityCountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_event_country, parent, false);
        return new UniversityCountryViewHolder(view, this.onCountrySelectedListener);
    }


    @Override
    public void onBindViewHolder(UniversityCountryViewHolder holder, int position) {
        holder.data = data.get(position);

        final String name = data.get(position).name;
        final String url = data.get(position).image;

        holder.lblCountryName.setText(name);

        Glide.with(context).load(url).into(holder.imageCountry);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class UniversityCountryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        @BindView(R.id.image_country_flag)
        ImageView imageCountry;

        @BindView(R.id.lbl_country_name)
        TextView lblCountryName;
        OnCountrySelectedListener onCountrySelectedListener;
        UniversityResult.Data data;

        public UniversityCountryViewHolder(View itemView, OnCountrySelectedListener onCountrySelectedListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            this.onCountrySelectedListener = onCountrySelectedListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(onCountrySelectedListener != null)
                onCountrySelectedListener.onCountrySelected(String.valueOf(data.getId()), data.getName());
        }
    }

    public interface OnCountrySelectedListener
    {
        void onCountrySelected(String countryId, String countryName);
    }
}
