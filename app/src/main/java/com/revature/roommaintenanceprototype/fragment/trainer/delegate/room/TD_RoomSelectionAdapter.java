package com.revature.roommaintenanceprototype.fragment.trainer.delegate.room;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;

import java.util.List;

public class TD_RoomSelectionAdapter extends RecyclerView.Adapter<TD_RoomSelectionAdapter.MyViewHolder>  {

    List<String> rooms;
    Activity activity;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public View parent;
        public Button button;
        public NavController navController;

        public MyViewHolder(View v){
            super(v);
            button = v.findViewById(R.id.room_selection_option_btn);
        }
    }

    public TD_RoomSelectionAdapter(Activity activity, List<String> rooms){
        this.rooms = rooms;
        this.activity = activity;
    }

    @NonNull
    @Override
    public TD_RoomSelectionAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_selection_option, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        vh.parent = parent;
        return vh;
    }

    public void onBindViewHolder(final MyViewHolder holder, final int position){
        holder.button.setText(rooms.get(position));

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public int getItemCount() {
        return rooms.size();
    }

}
