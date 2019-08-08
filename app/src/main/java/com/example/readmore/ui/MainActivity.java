package com.example.readmore.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.readmore.Constants;
import com.example.readmore.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

//    private Button mFindBooksButton;
    @BindView(R.id.buyBooksbutton) Button mFindBooksButton;
//    private Button mBookstoreButton;
    @BindView(R.id.Bookstorebutton) Button mBookstoreButton;
//    private TextView mAppNameTextView;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;
//    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        mFindBooksButton.setOnClickListener(this);

//        mBookstoreButton = (Button) findViewById(R.id.Bookstorebutton);
//        mFindBooksButton = (Button) findViewById(R.id.buyBooksbutton);
//        mAppNameTextView = (TextView) findViewById(R.id.appNameTextView);

        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/ostrich-regular.ttf");
        mAppNameTextView.setTypeface(ostrichFont);


        mBookstoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, BooksActivity.class);
                startActivity(intent1);
//                final ListView list = findViewById(R.id.listView);
            }
        });
        mFindBooksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == mFindBooksButton) {
                    Intent intent = new Intent(MainActivity.this, LibraryActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void addToSharedPreferences(String books) {
        mEditor.putString(Constants.PREFERENCES_BOOKS_KEY, books).apply();
    }

    @Override
    public void onClick(View v) {

    }
}




