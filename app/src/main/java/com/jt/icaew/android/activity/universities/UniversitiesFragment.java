package com.jt.icaew.android.activity.universities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jt.icaew.android.R;
import com.jt.icaew.android.activity.universities.adapter.UniversityCountryAdapter;
import com.jt.icaew.android.activity.universities.detail.UniversityDetailActivity;
import com.jt.icaew.android.network.university.UniversityResult;
import com.jt.icaew.android.utils.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wandy on 6/30/2016.
 */
public class UniversitiesFragment extends Fragment implements UniversityView.onFinishGetCountryListener, UniversityCountryAdapter.OnCountrySelectedListener {
    private UniversityPresenterImplementation implementation = new UniversityPresenterImplementation(this);
    private final String TAG = UniversitiesFragment.class.getSimpleName();
    private UniversityCountryAdapter adapter;

    @BindView(R.id.recycler_event_country)
    RecyclerView recylerCountry;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        implementation.getUniversity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onFinishGetCountry(UniversityResult universityResult) {
        adapter = new UniversityCountryAdapter(this.getContext(), universityResult.data, this);
        GridLayoutManager layoutManager = new GridLayoutManager(this.getContext(), 2);
        this.recylerCountry.setLayoutManager(layoutManager);
        recylerCountry.setAdapter(adapter);
    }

    @Override
    public void onCountrySelected(String countryId, String countryName) {
        Log.d(TAG, countryId);
        Intent intent = new Intent(getActivity(), UniversityDetailActivity.class);
        intent.putExtra(Constant.COUNTRY_ID, countryId);
        intent.putExtra(Constant.COUNTRY_NAME, countryName);
        startActivity(intent);
    }
}
