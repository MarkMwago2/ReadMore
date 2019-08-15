//package com.example.readmore.adapters;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.annotation.NonNull;
//
//import com.example.readmore.R;
//import com.example.readmore.models.Books;
//import com.example.readmore.util.ItemTouchHelperAdapter;
//import com.example.readmore.util.OnStartDragListener;
//
//import javax.net.ssl.SSLSession;
//
//public class FirebaseLibraryListAdapter extends FirebaseRecyclerAdapter<Books, FirebaseLibraryViewHolder> implements ItemTouchHelperAdapter {
//    private DatabaseReference mRef;
//    private OnStartDragListener mOnStartDragListener;
//    private Context mContext;
//
//    public FirebaseLibraryListAdapter(FirebaseRecyclerOptions<Books> options,
//                                         DatabaseReference ref,
//                                         OnStartDragListener onStartDragListener,
//                                         Context context){
//        super(options);
//        mRef = ref.getRef();
//        mOnStartDragListener = onStartDragListener;
//        mContext = context;
//    }
//
//    @Override
//    protected void onBindViewHolder(@NonNull final FirebaseLibraryViewHolder firebaseLibraryViewHolder, int position, @NonNull Books books) {
//        firebaseLibraryViewHolder.bindBooks(books);
//        firebaseLibraryViewHolder.mlibraryImageView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getActionMasked() == MotionEvent.ACTION_DOWN){
//                    mOnStartDragListener.onStartDrag(firebaseLibraryViewHolder);
//                }
//                return false;
//            }
//        });
//    }
//    {
//}
//    @NonNull
//    @Override
//    public FirebaseLibraryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.library_list_item_drag, parent, false);
//        return new FirebaseLibraryViewHolder(view);
//    }
//
//    @Override
//    public boolean onItemMove(int fromPosition, int toPosition){
//        notifyItemMoved(fromPosition, toPosition);
//        return false;
//    }
//
//    @Override
//    public void onItemDismiss(int position){
//        getRef(position).removeValue();
//    }
//
//    private SSLSession getRef(int position) {
//    }
//}