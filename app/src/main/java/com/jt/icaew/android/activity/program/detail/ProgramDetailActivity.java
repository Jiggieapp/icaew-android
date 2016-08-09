package com.jt.icaew.android.activity.program.detail;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.jt.icaew.android.App;
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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wandy on 7/12/2016.
 */
public class ProgramDetailActivity extends BaseActivity
        implements /*YouTubePlayer.OnInitializedListener*/
            ProgramView.OnFinishGetProgramDetailListener, ProgramView.OnLikeProgramListener, Html.ImageGetter {


    private final String TAG = ProgramDetailActivity.class.getSimpleName();
    @BindView(R.id.lin_share)
    LinearLayout linShare;
    @BindView(R.id.lin_like)
    LinearLayout linLike;
    @BindView(R.id.lin_inquiry)
    LinearLayout linInquiry;
    @BindView(R.id.lin_info)
    LinearLayout linInfo;
    @BindView(R.id.youtube_container)
    RelativeLayout youtubeContainer;
    private ProgramPresenterImplementation implementation;
    private String videoId;
    private static final int RECOVERY_DIALOG_REQUEST = 1;

    @BindView(R.id.lbl_program_description)
    TextView lblProgramDescription;
    String desc = "", url = "";

    YouTubePlayerSupportFragment frag;

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
        desc = programDetailResult.data.description.trim();
        url = programDetailResult.data.youtube;
        Spanned spanned = Html.fromHtml(Utils.getHtml(desc), this, null);
        lblProgramDescription.setText(/*Html.fromHtml (Utils.getHtml(desc))*/ spanned /*desc*/);

        //lblProgramDescription.setText(/*Html.fromHtml(Utils.getHtml(desc))*/ desc);
        //lblProgramDescription.setText(Html.fromHtml(Utils.getHtml(desc), this, null));
        if(programDetailResult.data.youtube != null)
        {
            youtubeContainer.setVisibility(View.VISIBLE);
            App.videoId = getVideoId(programDetailResult.data.youtube);
            // Initializing video player with developer key
            frag = (YouTubePlayerSupportFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.fragment_program_detail);
            frag.initialize(Constant.DEVELOPER_KEY, App.initializedListener);
        }
        else youtubeContainer.setVisibility(View.GONE);

    }

    /*@Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {
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
    }*/

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
        Utils.d(TAG, "like success");
    }

    @Override
    protected void onDestroy() {
        if(frag!=null)
            frag.onDestroy();
        super.onDestroy();
    }

    @Override
    public Drawable getDrawable(String source) {
        LevelListDrawable d = new LevelListDrawable();
        //Drawable empty = getResources().getDrawable(R.mipmap.ic_launcher);
        //d.addLevel(0, 0, empty);
        d.setBounds(0, 0, 0, 0);

        new LoadImage().execute(source, d);

        return d;
    }

    class LoadImage extends AsyncTask<Object, Void, Bitmap> {

        private LevelListDrawable mDrawable;

        @Override
        protected Bitmap doInBackground(Object... params) {
            String source = (String) params[0];
            mDrawable = (LevelListDrawable) params[1];
            try {
                InputStream is = new URL(source).openStream();
                return BitmapFactory.decodeStream(is);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                BitmapDrawable d = new BitmapDrawable(bitmap);
                mDrawable.addLevel(1, 1, d);
                final int width = bitmap.getWidth();
                final int height = bitmap.getHeight();

                Display display = getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);
                int paddingnya = dpToPx(36);
                int windowWidth = size.x - paddingnya;
                int windowHeight = size.y - paddingnya;

                final int desiredHeight = windowWidth * height / width;


                mDrawable.setBounds(0, 0, windowWidth, desiredHeight);
                mDrawable.setLevel(1);
                // i don't know yet a better way to refresh TextView
                // mTv.invalidate() doesn't work as expected
                CharSequence t = lblProgramDescription.getText();
                lblProgramDescription.setText(t);
            }
        }
    }

    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        //int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return (int)((dp * displayMetrics.density) + 0.5);
    }
}
