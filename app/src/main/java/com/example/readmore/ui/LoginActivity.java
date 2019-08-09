package com.example.readmore.ui;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


import androidx.appcompat.app.AppCompatActivity;

import com.example.readmore.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.registerTextView) TextView mRegisterTextView;
//    private Button mWelcomeButton;
    @BindView(R.id.passwordLoginButton) Button mWelcomeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        ButterKnife.bind(this);
        mRegisterTextView.setOnClickListener(this);

//        mWelcomeButton = (Button) findViewById(R.id.welcomeView1button);

        mWelcomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == mRegisterTextView) {
                    Intent intent = new Intent(LoginActivity.this, CreateAccountActivity.class);
                    startActivity(intent);
                    finish();
//                                                  final ListView list = findViewById(R.id.listView);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}