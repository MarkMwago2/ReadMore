package com.example.readmore.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.readmore.R;
import com.example.readmore.util.ItemTouchHelperAdapter;
import com.example.readmore.util.SimpleItemTouchHelperCallback;

import butterknife.BindView;

public class AllBooksActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mallbooksTextView;
    private ListView mallbooksListView;
    private String[] books = new String[]{"abstractart", "purple", "azkaban", "gatsby", "flights"};
    private GestureDetector gestureDetector = null;
//    private String[] images = new String[] {"@drawable/abstractart", "@drawable/purple", "@drawable/azkaban", "@drawable/gatsby", "@drawable/flights"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        mallbooksListView = (ListView) findViewById(R.id.allbookslistView);
        mallbooksTextView = (TextView) findViewById(R.id.allbooksTextView);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, books);
        mallbooksListView.setAdapter(adapter);


        mallbooksListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String restaurant = ((TextView) view).getText().toString();
                Toast.makeText(AllBooksActivity.this, restaurant, Toast.LENGTH_LONG).show();

                Intent intent = getIntent();
                String location = intent.getStringExtra("library");
                mallbooksTextView.setText("Here are all the books in the library ");

//
            }
        });
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return true;
}
}




