package com.revature.roommaintenanceprototype.adapter;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public interface OnItemClickListener extends View.OnClickListener {
    public void onItemClick(View view, int position);
}
