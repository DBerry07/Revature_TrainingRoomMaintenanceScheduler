package com.revature.roommaintenanceprototype.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;

import java.util.List;

public class TrainerSelectionAdapter extends RecyclerView.Adapter<TrainerSelectionAdapter.MyViewHolder>  {

    List<String> trainers;
    Activity activity;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public View parent;
        public Button button;
        public NavController navController;

        public MyViewHolder(View v){
            super(v);
            button = v.findViewById(R.id.trainer_selection_option_btn);
        }
    }

    public TrainerSelectionAdapter(Activity activity, List<String> trainers){
        this.trainers = trainers;
        this.activity = activity;
    }

    @NonNull
    @Override
    public TrainerSelectionAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.trainer_selection_option, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        vh.parent = parent;
        return vh;
    }

    public void onBindViewHolder(final MyViewHolder holder, final int position){
        holder.button.setText(trainers.get(position));

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    public int getItemCount() {
        return trainers.size();
    }

}
