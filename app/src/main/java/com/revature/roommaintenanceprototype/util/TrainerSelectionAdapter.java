package com.revature.roommaintenanceprototype.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;

import java.util.List;

public class TrainerSelectionAdapter extends RecyclerView.Adapter<TrainerSelectionAdapter.MyViewHolder>{

    public TrainerSelectionAdapter(Context context){}

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public Button button;
        public View parent;

        public MyViewHolder(View v){
            super(v);
            button = v.findViewById(R.id.trainer_selection_option_btn);
            parent = v;
        }
    }

    @NonNull
    @Override
    public TrainerSelectionAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.trainer_selection_option, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        vh.parent = parent;
        return vh;
    }

    public void onBindViewHolder(MyViewHolder holder, final int position){
        holder.button.setText("TRAINER_NAME");

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount(){
        return 1;
    }
}
