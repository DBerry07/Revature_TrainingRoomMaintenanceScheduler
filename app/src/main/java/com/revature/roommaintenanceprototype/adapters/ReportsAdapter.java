package com.revature.roommaintenanceprototype.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ReportsAdapter extends RecyclerView.Adapter<ReportsAdapter.MyViewHolder>  {

    Map<String, Boolean> roomStatus;
    Activity activity;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView roomName;
        TextView roomStatus;

        public MyViewHolder(View v){
            super(v);
            roomName = v.findViewById(R.id.reports_room_name);
            roomStatus = v.findViewById(R.id.reports_room_status);
        }
    }

    public ReportsAdapter(Activity activity, Map<String, Boolean> roomStatus){
        this.roomStatus = roomStatus;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ReportsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_reports, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    public void onBindViewHolder(final MyViewHolder holder, final int position){
        Set<String> keySet = roomStatus.keySet();
        Iterator<String> iter = keySet.iterator();
        ArrayList<String> keys = new ArrayList<>();

        while (iter.hasNext()){
            keys.add(iter.next());
        }

        if (roomStatus.get(keys.get(position)).toString().toUpperCase().equals("TRUE")) {
            holder.roomStatus.setText("COMPLETED");
        }
        else {
            holder.roomStatus.setText("TODO");
        }

        holder.roomName.setText(keys.get(position));
    }

    public int getItemCount() {
        return roomStatus.size();
    }

    public void updateList(Map<String, Boolean> list){
        this.roomStatus = list;
    }

}
