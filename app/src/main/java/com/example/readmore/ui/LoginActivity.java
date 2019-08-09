package com.example.readmore.ui;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;


import androidx.appcompat.app.AppCompatActivity;

import com.example.readmore.R;

public class LoginActivity extends AppCompatActivity {
//    private Button mWelcomeButton;
    @BindView(R.id.welcomeView1button) Button mWelcomeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

//        mWelcomeButton = (Button) findViewById(R.id.welcomeView1button);

        mWelcomeButton.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  Intent intent1 = new Intent(LoginActivity.this, MainActivity.class);
                                                  startActivity(intent1);
//                                                  final ListView list = findViewById(R.id.listView);
                                              }
                                          }
        );
    }
}