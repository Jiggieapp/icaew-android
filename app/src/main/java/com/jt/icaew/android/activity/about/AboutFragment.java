package com.jt.icaew.android.activity.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jt.icaew.android.R;
import com.jt.icaew.android.network.about.AboutResult;
import com.jt.icaew.android.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wandy on 6/30/2016.
 */
public class AboutFragment extends Fragment implements AboutView {

    @BindView(R.id.img_banner)
    ImageView imgBanner;
    @BindView(R.id.lin_share)
    LinearLayout linShare;
    @BindView(R.id.lin_like)
    LinearLayout linLike;
    @BindView(R.id.lin_inquiry)
    LinearLayout linInquiry;
    @BindView(R.id.lin_info)
    LinearLayout linInfo;
    private AboutPresenterImplementation implementation = new AboutPresenterImplementation(this);
    private final String TAG = AboutFragment.class.getSimpleName();

    @BindView(R.id.lbl_about_us)
    TextView lblAboutUs;
    String desc = "";

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

        linShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharePrograme();
            }
        });

        linLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        linInquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });

        linInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });

        return view;
    }

    @Override
    public void onFinishGetAbout(AboutResult aboutResult) {
        desc = aboutResult.data.description;
        lblAboutUs.setText(Html.fromHtml(Utils.getHtml(desc.trim())));
        Glide.with(getActivity()).load(aboutResult.data.image).into(imgBanner);
    }

    private void sharePrograme() {
        Intent i = new Intent(Intent.ACTION_SEND)
                .putExtra(Intent.EXTRA_TEXT, desc)
                .putExtra(Intent.EXTRA_SUBJECT, "ICAEW");
        i.setType("text/plain");
        startActivity(Intent.createChooser
                (i, "Share"));
    }

    private void sendEmail() {
        final Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "", null));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{""}); // hack for android 4.3
        intent.putExtra(Intent.EXTRA_SUBJECT, "ICAEW");
        super.startActivity(Intent.createChooser(intent, "Email"));
    }
}
