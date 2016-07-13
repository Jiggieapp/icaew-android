package com.jt.icaew.android.activity.about;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.util.Util;
import com.jt.icaew.android.R;
import com.jt.icaew.android.network.about.AboutResult;
import com.jt.icaew.android.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wandy on 6/30/2016.
 */
public class AboutFragment extends Fragment implements AboutView {

    private AboutPresenterImplementation implementation = new AboutPresenterImplementation(this);
    private final String TAG = AboutFragment.class.getSimpleName();

    @BindView(R.id.lbl_about_us)
    TextView lblAboutUs;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        implementation.getAbout();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onFinishGetAbout(AboutResult aboutResult) {
        Utils.d(TAG, "aboutresult "+ aboutResult.data.description);
        lblAboutUs.setText(aboutResult.data.title);
    }
}
