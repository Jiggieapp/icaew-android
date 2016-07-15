package com.jt.icaew.android.activity.program.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jt.icaew.android.R;
import com.jt.icaew.android.network.program.ProgramResult;
import com.jt.icaew.android.utils.Utils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wandy on 7/11/2016.
 */
public class ProgramAdapter extends RecyclerView.Adapter</*ProgramAdapter.ProgramViewHolder*/ RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<ProgramResult.Data> data;
    private final String TAG = ProgramAdapter.class.getSimpleName();
    OnProgramSelectedListener listener;

    private final int BODY = 1;
    private final int HEADER = 0;

    public ProgramAdapter(Context context, ArrayList<ProgramResult.Data> data, OnProgramSelectedListener listener)
    {
        this.context = context;
        this.data = data;
        Utils.d(TAG, "data " + data.size());
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == BODY)
        {
            View view = LayoutInflater.from(this.context).inflate(R.layout.item_program
                    , parent, false);
            return new ProgramViewHolder(view, this.listener);
        }
        else
        {
            View view = LayoutInflater.from(this.context).inflate(R.layout.item_image_header
                    , parent, false);
            return new ProgramHeaderViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if(viewHolder instanceof ProgramViewHolder)
        {
            ProgramViewHolder holder = (ProgramViewHolder) viewHolder;
            final String title = data.get(position).title;
            final String description = data.get(position).description;
            final String initial = data.get(position).initial;

            holder.data = data.get(position);
            holder.lblTitleProgram.setText(title);
            holder.lblDescriptionProgram.setText(description);
            holder.lblInitialProgram.setText(initial);
        }
        else if(viewHolder instanceof  ProgramHeaderViewHolder)
        {
            ProgramHeaderViewHolder holder = (ProgramHeaderViewHolder) viewHolder;
            Utils.d(TAG, "image " + data.get(0).image);
            Glide.with(context).load(data.get(0).image).into(holder.imgHeader);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public String getItem(final int position)
    {
        return data.get(position).id + "";
    }

    public class ProgramViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        @BindView(R.id.lbl_title_program)
        TextView lblTitleProgram;

        @BindView(R.id.lbl_description_program)
        TextView lblDescriptionProgram;

        @BindView(R.id.lbl_initial_program)
        TextView lblInitialProgram;

        OnProgramSelectedListener listener;
        ProgramResult.Data data;

        public ProgramViewHolder(View itemView, OnProgramSelectedListener listener) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(listener != null)
                listener.onProgramSelected(data);
        }
    }

    public class ProgramHeaderViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.img_header)
        ImageView imgHeader;

        public ProgramHeaderViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    public interface OnProgramSelectedListener
    {
        void onProgramSelected(ProgramResult.Data data);
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0)
            return HEADER;
        else
            return BODY;
    }
}
