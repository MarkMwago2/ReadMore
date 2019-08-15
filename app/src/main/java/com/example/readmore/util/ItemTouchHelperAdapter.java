package com.example.readmore.util;

import androidx.recyclerview.widget.ItemTouchHelper;

public interface ItemTouchHelperAdapter {
    boolean onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);

}