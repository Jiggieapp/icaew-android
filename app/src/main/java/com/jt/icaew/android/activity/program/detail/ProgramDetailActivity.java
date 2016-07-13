package com.jt.icaew.android.activity.program.detail;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.jt.icaew.android.R;
import com.jt.icaew.android.activity.AbstractBaseActivity;
import com.jt.icaew.android.activity.BaseActivity;
import com.jt.icaew.android.activity.program.ProgramPresenterImplementation;
import com.jt.icaew.android.activity.program.ProgramView;
import com.jt.icaew.android.network.program.ProgramDetailResult;
import com.jt.icaew.android.utils.Constant;
import com.jt.icaew.android.utils.Utils;


import java.util.StringTokenizer;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wandy on 7/12/2016.
 */
public class ProgramDetailActivity extends YouTubeBaseActivity
        implements ProgramView.OnFinishGetProgramDetailListener, YouTubePlayer.OnInitializedListener
{
    private ProgramPresenterImplementation implementation;
    private final String TAG = ProgramDetailActivity.class.getSimpleName();
    private static final int RECOVERY_DIALOG_REQUEST = 1;
    private String videoId;

    @BindView(R.id.lbl_program_description)
    TextView lblProgramDescription;

    @BindView(R.id.youtube_view)
    YouTubePlayerView youTubeView;

    public void onCreate() {
        setContentView(R.layout.activity_program_detail);
        ButterKnife.bind(this);
        implementation = new ProgramPresenterImplementation();
        implementation.setOnFinishGetProgramDetailListener(this);
        implementation.getProgramDetail("1");


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreate();
    }

    @Override
    public void onFinishGetProgramDetail(ProgramDetailResult programDetailResult) {
        //Utils.d(TAG, programDetailResult.data.description);
        youTubeView.initialize(Constant.DEVELOPER_KEY, this);
        lblProgramDescription.setText(programDetailResult.data.description);
        videoId = getVideoId(programDetailResult.data.youtube);
        // Initializing video player with developer key

    }

    private String getVideoId(final String original)
    {
        final String divider = "?v=";
        if(original.contains(divider))
        {
            //StringTokenizer tokenizer = new StringTokenizer("?v=");
            final int index = original.indexOf(divider);
            String result = original.substring(index+3, original.length());
            return result;
        }
        else return original;
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {
            /*String errorMessage = String.format(
                    getString(R.string.error_player), errorReason.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();*/
        }
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
}
