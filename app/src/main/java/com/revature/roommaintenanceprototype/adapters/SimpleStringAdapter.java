package com.revature.roommaintenanceprototype.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;

import java.util.ArrayList;

public class SimpleStringAdapter extends RecyclerView.Adapter<SimpleStringAdapter.StringViewHolder>{
    ArrayList<String> list;
    OnItemClickListener listener;

    public SimpleStringAdapter(ArrayList<String> list, OnItemClickListener listener){
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public StringViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_simple_string, parent, false);
        return new StringViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StringViewHolder holder, final int position) {
        holder.tvString.setText(list.get(position));
        holder.container.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                listener.onItemClick(view,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class StringViewHolder extends RecyclerView.ViewHolder{
        TextView tvString;
        LinearLayout container;

        public StringViewHolder(@NonNull final View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.container_row_simple_string);
            tvString = itemView.findViewById(R.id.tv_string);
        }
    }
}
