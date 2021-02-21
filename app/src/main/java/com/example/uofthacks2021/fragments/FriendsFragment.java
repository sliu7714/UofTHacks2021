package com.example.uofthacks2021.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.uofthacks2021.R;

public class FriendsFragment extends Fragment {

    VideoView videoView;
    ImageButton endcallButton;
    TextView endcallText;
    Button call_btn1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_friends, container, false);

//        videoView = (VideoView)root.findViewById(R.id.video_view);
//        videoView.setVideoPath("android.resource://" + getContext().getPackageName() + "/" + R.raw.vid1);
//
//
//        endcallButton = (ImageButton) root.findViewById(R.id.end_call_btn);
//        endcallText = (TextView)root.findViewById(R.id.hangup_tv);

//
//        call_btn1 = root.findViewById(R.id.call_btn1);
//        call_btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                call_btn1.setVisibility(View.INVISIBLE);
//                videoView.setVisibility(View.VISIBLE);
//                endcallButton.setVisibility(View.VISIBLE);
//                endcallText.setVisibility(View.VISIBLE);
//                videoView.start();
//
//            }
//        });

//        endcallButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                call_btn1.setVisibility(View.INVISIBLE);
//                videoView.setVisibility(View.INVISIBLE);
//                endcallButton.setVisibility(View.INVISIBLE);
//                endcallText.setVisibility(View.INVISIBLE);
//                videoView.pause();
//            }
//        });

        return root;
    }


    }