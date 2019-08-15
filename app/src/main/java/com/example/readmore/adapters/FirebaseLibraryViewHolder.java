//package com.example.readmore.adapters;
//
//import android.content.Context;
//import android.content.Intent;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.readmore.Constants;
//import com.example.readmore.R;
//import com.example.readmore.models.Books;
//import com.example.readmore.ui.LibraryActivity;
//import com.squareup.picasso.Picasso;
//
//import org.parceler.Parcels;
//
//import java.util.ArrayList;
//
//public class FirebaseLibraryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
//    View mView;
//    Context mContext;
//    public ImageView mlibraryImageView;
//
//    public FirebaseLibraryViewHolder(View itemView){
//        super(itemView);
//        mView = itemView;
//        mContext = itemView.getContext();
//        itemView.setOnClickListener(this);
//    }
//
//    public void bindRestaurant(Books books){
//        mlibraryImageView = mView.findViewById(R.id.libraryImageView);
//        TextView nameTextView = mView.findViewById(R.id.bookTitleTextView);
//        TextView categoryTextView = mView.findViewById(R.id.authorNameTextView);
//        TextView ratingTextView = mView.findViewById(R.id.ratingTextView);
//
//        nameTextView.setText(books.getTitle());
//        categoryTextView.setText(books.getAuthor());
//        ratingTextView.setText("Rating: " + books.getId() + "/5");
////        Picasso.get().load(books.getImageUrl()).into(mlibraryImageView);
//    }
//
//    @Override
//    public void onClick(View view){
//        final ArrayList<Books> books = new ArrayList<>();
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        String uid = user.getUid();
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_RESTAURANT).child(uid);
//        ref.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
//                    books.add(snapshot.getValue(Books.class));
//                }
//
//                int itemPosition = getLayoutPosition();
//                Intent intent = new Intent(mContext, LibraryActivity.class);
//                intent.putExtra("position", itemPosition + "");
//                intent.putExtra("restaurants", Parcels.wrap(books));
//
//                mContext.startActivity(intent);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }
//}
//
