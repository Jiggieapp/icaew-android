package com.jt.icaew.android.activity.program.detail;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.jt.icaew.android.R;
import com.jt.icaew.android.activity.BaseActivity;
import com.jt.icaew.android.activity.program.ProgramPresenterImplementation;
import com.jt.icaew.android.activity.program.ProgramView;
import com.jt.icaew.android.network.OnResponseListener;
import com.jt.icaew.android.network.actions.LikeManager;
import com.jt.icaew.android.network.actions.LikeResult;
import com.jt.icaew.android.network.program.ProgramDetailResult;
import com.jt.icaew.android.utils.Constant;
import com.jt.icaew.android.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wandy on 7/12/2016.
 */
public class ProgramDetailActivity extends BaseActivity
        implements YouTubePlayer.OnInitializedListener, ProgramView.OnFinishGetProgramDetailListener, ProgramView.OnLikeProgramListener {
    private final String TAG = ProgramDetailActivity.class.getSimpleName();
    @BindView(R.id.lin_share)
    LinearLayout linShare;
    @BindView(R.id.lin_like)
    LinearLayout linLike;
    @BindView(R.id.lin_inquiry)
    LinearLayout linInquiry;
    @BindView(R.id.lin_info)
    LinearLayout linInfo;
    private ProgramPresenterImplementation implementation;
    private String videoId;
    private static final int RECOVERY_DIALOG_REQUEST = 1;

    @BindView(R.id.lbl_program_description)
    TextView lblProgramDescription;
    String desc = "", url = "";

    @Override
    public void onCreate() {
        setContentView(R.layout.activity_program_detail);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            super.setSupportActionBar(toolbar);
            final String programName = getIntent().getBundleExtra("bundle")
                    .getString(Constant.PARAM_PROGRAM_NAME);

            getSupportActionBar().setTitle(programName);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        YouTubePlayerSupportFragment frag =
                (YouTubePlayerSupportFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.fragment_program_detail);
        frag.initialize(Constant.DEVELOPER_KEY, this);

        implementation = new ProgramPresenterImplementation();
        implementation.setOnFinishGetProgramDetailListener(this);

        final String programId = getIntent().getBundleExtra("bundle").getString(Constant.PARAM_PROGRAM_ID);
        implementation.getProgramDetail(programId);

        implementation.setOnFinishLikeProgramListener(this);
        linShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharePrograme();
            }
        });

        linLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                implementation.postLike(programId);
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

    }

    @Override
    public void onFinishGetProgramDetail(ProgramDetailResult programDetailResult) {
        //Utils.d(TAG, programDetailResult.data.description);
        //youTubeView.initialize(Constant.DEVELOPER_KEY, this);
        desc = programDetailResult.data.description;
        url = programDetailResult.data.youtube;
        lblProgramDescription.setText(programDetailResult.data.description);
        videoId = getVideoId(programDetailResult.data.youtube);
        // Initializing video player with developer key
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult errorReason) {
        /*if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {
            String errorMessage = String.format(
                    getString(R.string.error_player), errorReason.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }*/
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                        YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {

            // loadVideo() will auto play video
            // Use cueVideo() method, if you don't want to play it automatically
            player.cueVideo(videoId);

            // Hiding player controls
            //player.setPlayerStyle(YouTubePlayer.PlayerStyle.CHROMELESS);
        }
    }

    private String getVideoId(final String original) {
        final String divider = "?v=";
        if (original.contains(divider)) {
            //StringTokenizer tokenizer = new StringTokenizer("?v=");
            final int index = original.indexOf(divider);
            String result = original.substring(index + 3, original.length());
            return result;
        } else return original;
    }

    private void sharePrograme() {
        Intent i = new Intent(Intent.ACTION_SEND)
                .putExtra(Intent.EXTRA_TEXT, desc+"\n\n"+url)
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

    @Override
    public void onLikeProgram(LikeResult likeResult) {
        Log.d(TAG, "like success");
    }
}
