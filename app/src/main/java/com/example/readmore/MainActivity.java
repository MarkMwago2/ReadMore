package com.example.readmore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mFindBooksButton;
    private Button mBookstoreButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBookstoreButton = (Button) findViewById(R.id.Bookstorebutton);
        mFindBooksButton = (Button) findViewById(R.id.buyBooksbutton);

        mBookstoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, BooksActivity.class);
                startActivity(intent1);final ListView list = findViewById(R.id.listView);
            }
        });
        mFindBooksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LibraryActivity.class);
                startActivity(intent);final ListView list = findViewById(R.id.listView);

            };
        });
    }

            }



