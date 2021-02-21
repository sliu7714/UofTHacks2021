package com.example.uofthacks2021.fragments;

import android.media.Image;
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
    ImageButton help_btn;
    Button close_help_btn;
    LinearLayout helpView;

    View friend_pic;
    Button add_friend_btn, exit_vid_btn;
    TextView friend_name;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);


        videoView = (VideoView)root.findViewById(R.id.video_view);
        videoView.setVideoPath("android.resource://" + getContext().getPackageName() + "/" + R.raw.vid1);
        videoView.setVisibility(View.INVISIBLE);

        endcallButton = (ImageButton) root.findViewById(R.id.end_call_btn);
        endcallText = (TextView)root.findViewById(R.id.hangup_tv);

        connectingScreen = (LinearLayout)root.findViewById(R.id.connecting_view) ;

        friend_name = root.findViewById(R.id.user_name5);
        friend_pic =  root.findViewById(R.id.profile_picture5);
        exit_vid_btn  = root.findViewById(R.id.exit_vid_btn);
        add_friend_btn = root.findViewById(R.id.friend_btn4);



        connect_btn = root.findViewById(R.id.connect_btn);
        connect_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Connecting to call...",Toast.LENGTH_SHORT).show();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                connectingScreen.setVisibility(View.VISIBLE);
                Toast.makeText(getContext(), "You both like: Mystery Novels, Art, Cooking", Toast.LENGTH_LONG).show();
//
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

                videoView.setVisibility(View.INVISIBLE);
                endcallButton.setVisibility(View.INVISIBLE);
                endcallText.setVisibility(View.INVISIBLE);
                videoView.pause();
            }
        });
        exit_vid_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                connectingScreen.setVisibility(View.INVISIBLE);
                connect_btn.setVisibility(View.VISIBLE);

            }
        });

        final boolean[] is_friend = {false};
        add_friend_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(is_friend[0]){
                    add_friend_btn.setText("Add friend");
                    Toast.makeText(getContext(), "You removed Jenny Smith as a friend", Toast.LENGTH_SHORT).show();
                    is_friend[0] = false;
                }
                else {
                    add_friend_btn.setText("Remove friend");
                    Toast.makeText(getContext(), "You added Jenny Smith as a friend", Toast.LENGTH_SHORT).show();
                    is_friend[0] = true;
                }
            }
        });

        helpView = (LinearLayout)root.findViewById(R.id.help_view_home);

        help_btn = (ImageButton) root.findViewById(R.id.help_btn_home);
        help_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connect_btn.setVisibility(View.INVISIBLE);
                helpView.setVisibility(View.VISIBLE);
            }
        });


        close_help_btn =  root.findViewById(R.id.close_help_btn);
        close_help_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connect_btn.setVisibility(View.VISIBLE);
                helpView.setVisibility(View.INVISIBLE);
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