package com.example.readmore;

import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class LibraryActivity extends AppCompatActivity {
    public static final String TAG = LibraryActivity.class.getSimpleName();
    //    private TextView mbooksTextView;
    @BindView(R.id.booksTextView)
    TextView mbooksTextView;
    //    private ListView mListView;
    @BindView(R.id.listView)
    ListView mListView;
    private String[] books = new String[]{"abstractart", "purple", "azkaban", "gatsby", "flights"};
//    private String[] images = new String[] {"@drawable/abstractart", "@drawable/purple", "@drawable/azkaban", "@drawable/gatsby", "@drawable/flights"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        ButterKnife.bind(this);
        String title = "the monk";
        getTitle(title);

//        mListView = (ListView) findViewById(R.id.listView);
//        mbooksTextView = (TextView) findViewById(R.id.booksTextView);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, books);
        mListView.setAdapter(adapter);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String restaurant = ((TextView) view).getText().toString();
                Toast.makeText(LibraryActivity.this, restaurant, Toast.LENGTH_LONG).show();

                Intent intent = getIntent();
                String location = intent.getStringExtra("library");
                mbooksTextView.setText("Here are all the books in the library ");

            }
        });
    }

//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(LibraryActivity.this, BooksActivity.class);
//                    startActivity(intent);final ListView list = findViewById(R.id.listView);


                private void getTitle(String title) {
                    final ReadService readService = new ReadService();
                    readService.findTitle(title, new Callback() {

                        @Override
                        public void onFailure(Call call, IOException e) {
                            e.printStackTrace();
                        }
                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            try {
                                String jsonData = response.body().string();
                                Log.v(TAG, jsonData);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
}


