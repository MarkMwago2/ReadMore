package com.example.readmore.ui;

import android.content.Intent;
import android.graphics.Typeface;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import androidx.appcompat.app.AppCompatActivity;

import com.example.readmore.R;

public class MainActivity extends AppCompatActivity {
//    private Button mFindBooksButton;
    @BindView(R.id.buyBooksbutton) Button mFindBooksButton;
//    private Button mBookstoreButton;
    @BindView(R.id.Bookstorebutton) Button mBookstoreButton;
//    private TextView mAppNameTextView;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        mBookstoreButton = (Button) findViewById(R.id.Bookstorebutton);
//        mFindBooksButton = (Button) findViewById(R.id.buyBooksbutton);
//        mAppNameTextView = (TextView) findViewById(R.id.appNameTextView);

        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/ostrich-regular.ttf");
        mAppNameTextView.setTypeface(ostrichFont);


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



