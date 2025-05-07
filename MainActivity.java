package com.example.mediaplayer;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import com.example.mediaplayer.R;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = null;
    }

    public void onmusic(View view) {
        int id = view.getId();

        if (id == R.id.b1) {
            if (mp == null) {
                mp = MediaPlayer.create(this, R.raw.music2);
            }
//            mp.setOnCompletionListener(mp -> stopmusic());

            mp.start();
        } else if (id == R.id.b2) {
            if (mp != null) {
                mp.pause();
            }
        } else if (id == R.id.b3) {
            if (mp != null) {
                mp.stop();
                stopmusic();
            }
        }
    }

    private void stopmusic() {
        mp.release();
        mp = null;
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopmusic();
    }
}