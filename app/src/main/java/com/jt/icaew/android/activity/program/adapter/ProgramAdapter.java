package com.jt.icaew.android.activity.program.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jt.icaew.android.R;
import com.jt.icaew.android.network.program.ProgramResult;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wandy on 7/11/2016.
 */
public class ProgramAdapter extends RecyclerView.Adapter<ProgramAdapter.ProgramViewHolder> {

    private Context context;
    private ArrayList<ProgramResult.Data> data;
    private final String TAG = ProgramAdapter.class.getSimpleName();
    OnProgramSelectedListener listener;

    public ProgramAdapter(Context context, ArrayList<ProgramResult.Data> data, OnProgramSelectedListener listener)
    {
        this.context = context;
        this.data = data;
        this.listener = listener;
    }

    @Override
    public ProgramViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.item_program
                , parent, false);
        return new ProgramViewHolder(view, this.listener);
    }

    @Override
    public void onBindViewHolder(ProgramViewHolder holder, int position) {
        final String title = data.get(position).title;
        final String description = data.get(position).description;
        final String initial = data.get(position).initial;

        holder.data = data.get(position);
        holder.lblTitleProgram.setText(title);
        holder.lblDescriptionProgram.setText(description);
        holder.lblInitialProgram.setText(initial);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public String getItem(final int position)
    {
        return data.get(position).id + "";
    }

    static class ProgramViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
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

    public interface OnProgramSelectedListener
    {
        void onProgramSelected(ProgramResult.Data data);
    }
}
