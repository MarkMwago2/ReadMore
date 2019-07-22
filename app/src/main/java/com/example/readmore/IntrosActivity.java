package com.example.readmore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class IntrosActivity extends AppCompatActivity {
    private Button mWelcomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intros);

        mWelcomeButton = (Button) findViewById(R.id.welcomeView1button);

        mWelcomeButton.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  Intent intent1 = new Intent(IntrosActivity.this, MainActivity.class);
                                                  startActivity(intent1);
                                                  final ListView list = findViewById(R.id.listView);
                                              }
                                          }
        );
    }
}