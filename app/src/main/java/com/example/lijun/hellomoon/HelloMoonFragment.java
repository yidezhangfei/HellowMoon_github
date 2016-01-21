package com.example.lijun.hellomoon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by lijun on 16/1/21.
 */
public class HelloMoonFragment extends Fragment {
    private Button mPlayButton;
    private Button mStopButton;
    private Button mPauseButton;

    private AudioPlayer mAudioPlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState) {
        View  view = inflater.inflate(R.layout.fragment_hello_moon, parent);

        mPlayButton = (Button) view.findViewById(R.id.hellomoon_playButton);
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAudioPlayer != null)
                    mAudioPlayer.play(getActivity());
            }
        });

        mStopButton = (Button) view.findViewById(R.id.hellomoon_stopButton);
        mStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAudioPlayer != null)
                    mAudioPlayer.stop();
            }
        });

        mPauseButton = (Button) view.findViewById(R.id.hellomoon_pauseButton);
        mPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                String text = button.getText().toString();
                String pauseString = getResources().getString(R.string.hellomoon_pause);
                String resumeString = getResources().getString(R.string.hellomoon_resume);
                if (text == pauseString) {
                    if (mAudioPlayer != null) {
                        mAudioPlayer.pause();
                        button.setText(resumeString);
                    }
                } else if (text == resumeString) {
                    if (mAudioPlayer != null) {
                        mAudioPlayer.resume();
                        button.setText(pauseString);
                    }
                }
            }
        });



        mAudioPlayer = new AudioPlayer();

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mAudioPlayer.stop();
    }
}
