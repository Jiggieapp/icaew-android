package com.jt.icaew.android.activity.contact.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jt.icaew.android.R;
import com.jt.icaew.android.network.contact.ContactDetailResult;
import com.jt.icaew.android.utils.Utils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LTE on 8/9/2016.
 */
public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ContactListViewHolder> {

    private Activity a;
    private ArrayList<ContactDetailResult.Data> data;
    private final String TAG = ContactListAdapter.class.getSimpleName();
    OnContactListSelectedListener onViewSelectedListener;

    public ContactListAdapter(Activity a, ArrayList<ContactDetailResult.Data> data, OnContactListSelectedListener listener) {
        this.a = a;
        this.data = data;
        this.onViewSelectedListener = listener;
    }

    @Override
    public ContactListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(a).inflate(R.layout.item_contact_detail, parent, false);
        ButterKnife.bind(this, view);
        return new ContactListViewHolder(view, onViewSelectedListener);
    }

    @Override
    public void onBindViewHolder(ContactListViewHolder holder, int position) {
        ContactDetailResult.Data datas = data.get(position);

        holder.data = datas;

        if(position == 0)
        {
            if (datas.getImage().isEmpty()) {
                Glide.with(a).load(R.drawable.default_banner_bg).into(holder.imgBanner);
            } else {
                Glide.with(a).load(datas.getImage()).into(holder.imgBanner);
            }
        }
        else holder.imgBanner.setVisibility(View.GONE);

        holder.lblUniversityName.setText(a.getResources().getString(R.string.icaew) + " " + datas.country_name);
        holder.lblUniversityAddress.setText(datas.getAddress());
        holder.lblUniversityEmail.setText(datas.getEmail());
        holder.lblUniversityPhone.setText(datas.getTelp());
        holder.lblUniversityFacebook.setText(datas.getFacebook());
        //holder.lblUniversityWebsite.setText(datas.getWebsite());
    }

    @Override
    public int getItemCount() {
        int size = 0;
        if (data == null) {
            size = 0;
        } else {
            if (data.size() == 0) {
                size = 0;
            } else {
                size = data.size();
            }
        }
        return size;
    }

    static class ContactListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.img_banner)
        ImageView imgBanner;
        @BindView(R.id.lbl_university_name)
        TextView lblUniversityName;
        @BindView(R.id.lbl_university_address)
        TextView lblUniversityAddress;
        @BindView(R.id.lbl_university_phone)
        TextView lblUniversityPhone;
        @BindView(R.id.lbl_university_email)
        TextView lblUniversityEmail;
        @BindView(R.id.lbl_university_facebook)
        TextView lblUniversityFacebook;
        /*@BindView(R.id.lbl_university_website)
        TextView lblUniversityWebsite;*/

        ContactDetailResult.Data data;
        OnContactListSelectedListener onViewSelectedListener;

        public ContactListViewHolder(View itemView, OnContactListSelectedListener listener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.onViewSelectedListener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }

    public interface OnContactListSelectedListener {
        void onContactListSelected(ContactDetailResult.Data data);
    }

}
