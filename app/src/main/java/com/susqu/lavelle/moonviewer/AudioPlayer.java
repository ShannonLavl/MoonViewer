package com.susqu.lavelle.moonviewer;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by Shannon on 2/17/2015.
 */
public class AudioPlayer {
    private MediaPlayer mPlayer;

    public void stop() {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void play(Context c) {
        if (mPlayer != null) {
            mPlayer.start();
            return;
        }

        mPlayer = MediaPlayer.create(c, R.raw.one_small_step);

        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });

        mPlayer.start();
    }

    public void pause() {
        mPlayer.pause();
    }
}
