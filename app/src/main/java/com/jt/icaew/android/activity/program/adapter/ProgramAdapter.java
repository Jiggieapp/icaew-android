package com.jt.icaew.android.activity.program.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jt.icaew.android.R;
import com.jt.icaew.android.activity.program.ProgramResult;
import com.jt.icaew.android.utils.Utils;

import org.w3c.dom.Text;

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

    public ProgramAdapter(Context context, ArrayList<ProgramResult.Data> data)
    {
        this.context = context;
        this.data = data;
    }

    @Override
    public ProgramViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.item_program
                , parent, false);
        return new ProgramViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProgramViewHolder holder, int position) {
        final String title = data.get(position).title;
        final String description = data.get(position).description;
        final String initial = data.get(position).initial;

        holder.lblTitleProgram.setText(title);
        holder.lblDescriptionProgram.setText(description);
        holder.lblInitialProgram.setText(initial);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ProgramViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.lbl_title_program)
        TextView lblTitleProgram;

        @BindView(R.id.lbl_description_program)
        TextView lblDescriptionProgram;

        @BindView(R.id.lbl_initial_program)
        TextView lblInitialProgram;

        public ProgramViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
