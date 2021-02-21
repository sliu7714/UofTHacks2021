package com.example.uofthacks2021;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sinch.android.rtc.ClientRegistration;
import com.sinch.android.rtc.PushPair;
import com.sinch.android.rtc.Sinch;
import com.sinch.android.rtc.SinchClient;
import com.sinch.android.rtc.SinchClientListener;
import com.sinch.android.rtc.SinchError;
import com.sinch.android.rtc.calling.Call;
import com.sinch.android.rtc.calling.CallClient;
import com.sinch.android.rtc.calling.CallListener;
import com.sinch.android.rtc.video.VideoController;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Homepage_Activity extends AppCompatActivity {

//    RecyclerView videoView;

//    FirebaseAuth auth;
//    FirebaseUser user;
//    SinchClient sinchClient;
//    Call call;
//    //ArrayList<User> users; //TODO use User class
//    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage_);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_profile, R.id.navigation_friends)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);




//        //
//        videoView = (RecyclerView)findViewById(R.id.video_view);
//        videoView.setHasFixedSize(true);
//        videoView.setLayoutManager(new RecyclerView.LayoutManager() {
//            @Override
//            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
//                return null;
//            }
//        });

//        reference = FirebaseDatabase.getInstance().getReference().child("Users");

//        auth = FirebaseAuth.getInstance();
//        user = auth.getCurrentUser();

//        // -------------------- taken from sinch website tutorial ----------------------------
//        // Instantiate a SinchClient using the SinchClientBuilder.
//        android.content.Context context = this.getApplicationContext();
//        SinchClient sinchClient = Sinch.getSinchClientBuilder()
//                .context(context)
//                .applicationKey("36b1d108-028e-432c-a41f-2824ecd009a3")
//                .applicationSecret("dc4zpFKsFUW/jP4K9qNQtQ==")
//                .environmentHost("clientapi.sinch.com")
//                .userId(user.getUid())
//                .build();
//
//        sinchClient.addSinchClientListener(new SinchClientListener() {
//
//            public void onClientStarted(SinchClient client) { }
//
//            public void onClientStopped(SinchClient client) { }
//
//            public void onClientFailed(SinchClient client, SinchError error) {}
//
//            public void onRegistrationCredentialsRequired(SinchClient client, ClientRegistration registrationCallback) { }
//
//            public void onLogMessage(int level, String area, String message) { }
//        });
//
//        sinchClient.start();
//
//        // ------------------------------------------------------------------------
//        sinchClient.setSupportCalling(true);
//
//
//        CallClient callClient = sinchClient.getCallClient();
//
//        // making calls
//
//        call = callClient.callUserVideo("<remote user id>"); //TODO? how to get remote userID
//        call.addCallListener(new CallListener() {
//            @Override
//            public void onCallProgressing(Call call) {
//                Toast.makeText(getApplicationContext(), "Ringing...", Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onCallEstablished(Call call) {
//                Toast.makeText(getApplicationContext(), "Starting call...", Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onCallEnded(Call endCall) {
//                Toast.makeText(getApplicationContext(), "Call ended", Toast.LENGTH_LONG).show();
//                call = null;
//                endCall.hangup(); //renamed to not override call in outer scope
//
//                // Todo: remove sinch video view from view hierarchy
//            }
//
//            @Override
//            public void onShouldSendPushNotification(Call call, List<PushPair> list) {
//
//            }

            // idk??? recieving calls
//            @Override
//            public void onIncomingCall(CallClient callClient, Call call) {
//                // TODO? Start playing ringing tone
//
//                // Add call listener
////                call.addCallListener(...);
//                // if user wants to answer
//                call.answer();
//
//                // if user wants to decline
////                call.hangup();
//            }
//        });

        // video stuff
//        @Override
//        public void onVideoTrackAdded(Call call) {
//            // Get a reference to your SinchClient, in the samples this is done through the service interface:
//            VideoController vc = getSinchServiceInterface().getVideoController();
//            View myPreview = vc.getLocalView();
//            View remoteView = vc.getRemoteView();
//
//            // Add the views to your view hierarchy
//        }


        // ------------------------------------------------------------------------



    }






}