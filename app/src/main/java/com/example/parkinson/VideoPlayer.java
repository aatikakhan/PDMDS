package com.example.parkinson;


import android.os.Bundle;
import android.widget.Toast;

import com.example.parkinson.java.Config1;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;
public class VideoPlayer extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{

    public static final String API_KEY="AIzaSyBsp3wq3YsiR0c6DnU1P1-BiEN6ahGEX8Q";

    // public static final String VIDEO_ID="79QVOvYLDTQ";
    //public static final String VIDEO_ID="4y1on3YkU1c";

    public  static String VIDEO_ID="";
    //public static final String VIDEO_ID= Config1.passenger.para3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);


        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(API_KEY,this);

    }
    protected void onResume() {
        super.onResume();

        VIDEO_ID= Config1.passenger.para3;
    }
    public void onInitializationFailure (Provider provider, YouTubeInitializationResult result){

        Toast.makeText(this,"Failure to Initialize", Toast.LENGTH_LONG).show();

    }

    public void onInitializationSuccess (Provider provider, YouTubePlayer player, boolean wasRestored)

    {

        player.setPlayerStateChangeListener(playerStateChangeListener);
        player.setPlaybackEventListener(playbackEventListener);
        if(!wasRestored)
        {
            player.cueVideo(VIDEO_ID);
        }
    }

    private PlaybackEventListener playbackEventListener = new PlaybackEventListener() {
        @Override
        public void onPlaying() {

        }

        @Override
        public void onPaused() {

        }

        @Override
        public void onStopped() {

        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };

    private PlayerStateChangeListener playerStateChangeListener= new PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {

        }

        @Override
        public void onVideoStarted() {

        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onError(ErrorReason errorReason) {

        }
    };

}
