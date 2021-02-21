package com.example.uofthacks2021.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.uofthacks2021.R;

public class FriendsFragment extends Fragment {

    VideoView videoView;
    ImageButton endcallButton;
    TextView endcallText;
    Button call_btn1;
    LinearLayout connectingScreen;

    RelativeLayout friendView;
    Button see_friend_profile, friend_btn;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_friends, container, false);

        videoView = (VideoView)root.findViewById(R.id.video_view2);
        videoView.setVideoPath("android.resource://" + getContext().getPackageName() + "/" + R.raw.vid1);


        endcallButton = (ImageButton) root.findViewById(R.id.end_call_btn2);
        endcallText = (TextView)root.findViewById(R.id.hangup_tv2);

        connectingScreen = (LinearLayout)root.findViewById(R.id.connecting_view) ;


        call_btn1 = root.findViewById(R.id.call_btn1);
        call_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Connecting to call...",Toast.LENGTH_SHORT).show();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                connectingScreen.setVisibility(View.VISIBLE);
                call_btn1.setVisibility(View.INVISIBLE);
                videoView.setVisibility(View.VISIBLE);
                endcallButton.setVisibility(View.VISIBLE);
                endcallText.setVisibility(View.VISIBLE);
                videoView.start();

            }
        });

        endcallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                call_btn1.setVisibility(View.VISIBLE);
                videoView.setVisibility(View.INVISIBLE);
                connectingScreen.setVisibility(View.INVISIBLE);
                endcallButton.setVisibility(View.INVISIBLE);
                endcallText.setVisibility(View.INVISIBLE);
                videoView.pause();
            }
        });

        friendView = (RelativeLayout)root.findViewById(R.id.friend_profile_view);

        see_friend_profile = (Button)root.findViewById(R.id.view_profile_btn1);
        see_friend_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                friendView.setVisibility(View.VISIBLE);
            }
        });

        friend_btn = (Button)root.findViewById(R.id.friend_btn);
        final boolean[] is_friend = {true};
        friend_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(is_friend[0]){
                    friend_btn.setText("Add friend");
                    Toast.makeText(getContext(), "You removed Jenny Smith as a friend", Toast.LENGTH_SHORT).show();
                    is_friend[0] = false;
                }
                else {
                    friend_btn.setText("Remove friend");
                    Toast.makeText(getContext(), "You added Jenny Smith as a friend", Toast.LENGTH_SHORT).show();
                    is_friend[0] = true;
                }
            }
        });

        return root;
    }


    }