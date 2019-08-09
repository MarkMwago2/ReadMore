package com.example.readmore.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import java.util.*;

import com.example.readmore.Constants;
import com.example.readmore.adapters.LibraryListAdapter;
import com.example.readmore.models.Books;
import com.example.readmore.R;
import com.example.readmore.service.ReadService;


public class LibraryActivity extends AppCompatActivity {
    public static final String TAG = LibraryActivity.class.getSimpleName();
    //    private TextView mbooksTextView;
    @BindView(R.id.booksTextView) TextView mbooksTextView;
    //    private ListView mListView;
//    @BindView(R.id.listView)ListView mListView;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    private LibraryListAdapter mAdapter;
    private ArrayList<Books> books = new ArrayList<>();

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private String mRecentTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        ButterKnife.bind(this);
        String title = "the monk";


        Intent intent = getIntent();
        String location = intent.getStringExtra("library");
        mbooksTextView.setText("Here are all the books in the library ");


        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mRecentTitle = mSharedPreferences.getString(Constants.PREFERENCES_BOOKS_KEY, null);
        if (mRecentTitle != null) {
            getTitle(title);

//        mListView = (ListView) findViewById(R.id.listView);
//        mbooksTextView = (TextView) findViewById(R.id.booksTextView);
        }
    }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_search, menu);
            ButterKnife.bind(this);

            mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            mEditor = mSharedPreferences.edit();

            MenuItem menuItem = menu.findItem(R.id.action_search);
            SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);

            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

                @Override
                public boolean onQueryTextSubmit(String query) {
                    addToSharedPreferences(query);
                    getTitle(query);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });

            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            return super.onOptionsItemSelected(item);
        }

//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(LibraryActivity.this, BooksActivity.class);
//                    startActivity(intent);final ListView list = findViewById(R.id.listView);


        private void getTitle(String title){
            final ReadService readService = new ReadService();
            readService.findTitle(title, new Callback() {


                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) {
                    books = readService.processResults(response);
                    LibraryActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter = new LibraryListAdapter(LibraryActivity.this, books);
                            mRecyclerView.setAdapter(mAdapter);
                            RecyclerView.LayoutManager layoutManager =
                                    new LinearLayoutManager(LibraryActivity.this);
                            mRecyclerView.setLayoutManager(layoutManager);
                            mRecyclerView.setHasFixedSize(true);
//                            String[] bookNames = new String[books.size()];
//                            for (int i = 0; i < bookNames.length; i++) {
//                                bookNames[i] = books.get(i).getTitle();
//
//                                ArrayAdapter adapter = new ArrayAdapter(LibraryActivity.this, android.R.layout.simple_list_item_1, bookNames);
//                                mListView.setAdapter(adapter);
//
//                                for (Books book : books) {
//                                    Log.d(TAG, "Title: " + book.getTitle());
//                                    Log.d(TAG, "Author: " + book.getAuthor());
//                                    Log.d(TAG, "Id: " + book.getId());


                        }
                    });
                }
            });

        }
    private void addToSharedPreferences(String books) {
        mEditor.putString(Constants.PREFERENCES_BOOKS_KEY, books).apply();
    }
    }
