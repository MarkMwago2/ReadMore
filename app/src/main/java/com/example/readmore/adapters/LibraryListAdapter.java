package com.example.readmore.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.readmore.R;
import com.example.readmore.models.Books;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LibraryListAdapter extends RecyclerView.Adapter<LibraryListAdapter.LibraryViewHolder> {
    private ArrayList<Books> mbooks = new ArrayList<>();
    private Context mContext;

    public LibraryListAdapter(Context context, ArrayList<Books> books) {
        mContext = context;
        mbooks = books;
    }
    @Override
    public LibraryListAdapter.LibraryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.library_list_item, parent, false);
        LibraryViewHolder viewHolder = new LibraryViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LibraryListAdapter.LibraryViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mbooks.size();
    }

    public class LibraryViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.libraryImageView) ImageView mlibraryImageView;
        @BindView(R.id.bookTitleTextView) TextView mNameTextView;
        @BindView(R.id.authorNameTextView) TextView mCategoryTextView;
        @BindView(R.id.ratingTextView) TextView mRatingTextView;

        private Context mContext;

        public LibraryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindRestaurant(Books books) {
            mNameTextView.setText(books.getTitle());
            mCategoryTextView.setText(books.getAuthor());
            mRatingTextView.setText("Rating: " + books.getId() );
        }
    }
}