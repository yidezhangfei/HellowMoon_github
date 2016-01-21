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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState) {
        View  view = inflater.inflate(R.layout.fragment_hello_moon, parent);

        mPlayButton = (Button) view.findViewById(R.id.hellomoon_playButton);
        mStopButton = (Button) view.findViewById(R.id.hellomoon_stopButton);

        return view;
    }
}
