package com.jt.icaew.android;

import android.app.Application;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;

/**
 * Created by Wandy on 7/15/2016.
 */
public class App extends Application implements YouTubePlayer.OnInitializedListener{
    public static String videoId;
    public static YouTubePlayer.OnInitializedListener initializedListener;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializedListener = this;
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {

            // loadVideo() will auto play video
            // Use cueVideo() method, if you don't want to play it automatically
            player.cueVideo(videoId);

            // Hiding player controls
            //player.setPlayerStyle(YouTubePlayer.PlayerStyle.CHROMELESS);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}
