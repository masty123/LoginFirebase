package com.example.loginfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;


public class  Signin extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private TextView email;
    private Button newPost, viewPost, location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        mAuth = FirebaseAuth.getInstance();
        email = (TextView) findViewById(R.id.email);
        email.setText(mAuth.getCurrentUser().getEmail());
        newPost = (Button) findViewById(R.id.newPost);
        viewPost = (Button) findViewById(R.id.viewPostData);
        location = (Button) findViewById(R.id.location);

        newPost.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),newPost.class));
            }
        });

        viewPost .setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),viewPost.class));

            }
        });

        location.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), viewLocation.class));

            }
        });

    }

    public void onLogoutButtonClicked(View view) {
        mAuth.signOut();
        Intent i = new Intent(Signin.this, MainActivity.class);
        finish();
        startActivity(i);
    }


}
