package com.example.uofthacks2021;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText email, password;
    FirebaseAuth auth;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //firebase
        auth = FirebaseAuth.getInstance();

        // set up textboxes and buttons
        email = (EditText)findViewById(R.id.email_tb);
        password = (EditText)findViewById(R.id.password_tb);

        login = (Button)findViewById(R.id.login_btn);
        //login button
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login(v);
            }
        });
    }

    public void Login(View v){
        String email_str = email.getText().toString();
        String password_str = password.getText().toString();

        // if pass and email are not empty try to authenticate info
        if (!email_str.equals("") && !password_str.equals("")){

            auth.signInWithEmailAndPassword(email_str, password_str)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                // change to homepage activity
                                //TODO: deal with user info
                                Toast.makeText(getApplicationContext(),
                                        "Signed in as " + email_str,
                                        Toast.LENGTH_LONG).show();
                                startActivity(new Intent(LoginActivity.this,Homepage_Activity.class));
                            }
                            else{
                                // message to user that authentication failed
                                Toast.makeText(getApplicationContext(),
                                        "Sorry you could not login, Please try again.",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }
        else{
            Toast.makeText(getApplicationContext(),
                    "Please enter your email and password first",
                    Toast.LENGTH_LONG).show();
        }
    }

}