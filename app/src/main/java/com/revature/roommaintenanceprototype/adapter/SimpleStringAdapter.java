package com.revature.roommaintenanceprototype.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;

import java.util.ArrayList;

public class SimpleStringAdapter extends RecyclerView.Adapter<SimpleStringAdapter.StringViewHolder>{
    ArrayList<String> list;

    public SimpleStringAdapter(ArrayList<String> list){
        this.list = list;
    }

    @NonNull
    @Override
    public StringViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_simple_string, parent, false);
        return new StringViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StringViewHolder holder, int position) {
        holder.tvString.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class StringViewHolder extends RecyclerView.ViewHolder{
        TextView tvString;

        public StringViewHolder(@NonNull final View itemView) {
            super(itemView);
            tvString = itemView.findViewById(R.id.tv_string);
        }
    }
}
