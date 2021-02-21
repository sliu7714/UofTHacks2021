package com.example.uofthacks2021.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.uofthacks2021.R;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HomeFragment extends Fragment {

    VideoView videoView;
    ImageButton endcallButton;
    TextView endcallText;
    LinearLayout connectingScreen;
    Button connect_btn;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);


        videoView = (VideoView)root.findViewById(R.id.video_view);
        videoView.setVideoPath("android.resource://" + getContext().getPackageName() + "/" + R.raw.vid1);
        videoView.setVisibility(View.INVISIBLE);

        endcallButton = (ImageButton) root.findViewById(R.id.end_call_btn);
        endcallText = (TextView)root.findViewById(R.id.hangup_tv);

        connectingScreen = (LinearLayout)root.findViewById(R.id.connecting_view) ;


        connect_btn = root.findViewById(R.id.connect_btn);
        connect_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectingScreen.setVisibility(View.VISIBLE);

//                ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
//
//                executorService.schedule(HomeFragment.this::ConnectCall, 2, TimeUnit.SECONDS);
                connect_btn.setVisibility(View.INVISIBLE);
                videoView.setVisibility(View.VISIBLE);
                endcallButton.setVisibility(View.VISIBLE);
                endcallText.setVisibility(View.VISIBLE);
                videoView.start();

            }
        });

        endcallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connect_btn.setVisibility(View.INVISIBLE);
                videoView.setVisibility(View.INVISIBLE);
                endcallButton.setVisibility(View.INVISIBLE);
                endcallText.setVisibility(View.INVISIBLE);
                connectingScreen.setVisibility(View.INVISIBLE);
                videoView.pause();
            }
        });



        return root;

    }



    private void ConnectCall(){
        connect_btn.setVisibility(View.INVISIBLE);
        videoView.setVisibility(View.VISIBLE);
        endcallButton.setVisibility(View.VISIBLE);
        endcallText.setVisibility(View.VISIBLE);
        videoView.start();

    }

}