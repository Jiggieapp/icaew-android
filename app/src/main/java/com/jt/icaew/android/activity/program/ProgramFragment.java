package com.jt.icaew.android.activity.program;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jt.icaew.android.R;
import com.jt.icaew.android.activity.program.adapter.ProgramAdapter;
import com.jt.icaew.android.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wandy on 6/30/2016.
 */
public class ProgramFragment extends Fragment implements ProgramView{

    private final String TAG = ProgramFragment.class.getSimpleName();
    ProgramPresenterImplementation implementation = new ProgramPresenterImplementation(this);

    @BindView(R.id.recycler_program)
    RecyclerView recyclerProgram;

    private ProgramAdapter adapter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        implementation.getProgram();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_program, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onFinishGetProgram(ProgramResult programResult) {
        //Utils.d(TAG, programResult.data[0].title);
        adapter = new ProgramAdapter(this.getContext(), programResult.data);
        Utils.d(TAG, programResult.data.size() + "");
        LinearLayoutManager layoutManager = new LinearLayoutManager(super.getContext());
        this.recyclerProgram.setLayoutManager(layoutManager);
        recyclerProgram.setAdapter(adapter);
    }
}
