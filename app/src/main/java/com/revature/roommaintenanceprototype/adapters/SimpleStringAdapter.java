package com.revature.roommaintenanceprototype.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.controllers.workflowpersistance.TRVerifyPersistance;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.FragmentHelper;

import java.util.ArrayList;
import java.util.List;

public class SimpleStringAdapter extends RecyclerView.Adapter<SimpleStringAdapter.StringViewHolder>{
    private static final String DEBUG_TAG = "SimpleStringAdapter";
    private String selectedItem;

    private ArrayList<String> list;
    private ArrayList<View> listOfItems;
    private OnItemClickListener listener;

    public SimpleStringAdapter(ArrayList<String> list, OnItemClickListener listener){
        this.list = list;
        this.listener = listener;
        this.listOfItems = new ArrayList<>();
        this.selectedItem = "";
    }

    public SimpleStringAdapter(ArrayList<String> list, OnItemClickListener listener,String selectedItem){
        this.list = list;
        this.listener = listener;
        this.listOfItems = new ArrayList<>();
        this.selectedItem = selectedItem;
    }

    public ArrayList<View> getListOfItems() {
        return listOfItems;
    }

    @NonNull
    @Override
    public StringViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_simple_string, parent, false);
        return new StringViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final StringViewHolder holder, final int position) {
        holder.tvString.setText(list.get(position));
        holder.container.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                listener.onItemClick(view,position);
            }
        });

        FragmentHelper.restoreSimpleTextChoice(holder.container, selectedItem);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class StringViewHolder extends RecyclerView.ViewHolder{
        private TextView tvString;
        private LinearLayout container;

        public StringViewHolder(@NonNull final View itemView) {
            super(itemView);
            listOfItems.add(itemView);
            container = itemView.findViewById(R.id.container_row_simple_string);
            tvString = itemView.findViewById(R.id.tv_string);
        }

        public TextView getTvString() {
            return tvString;
        }

        public LinearLayout getContainer() {
            return container;
        }
    }

    public void updateList(ArrayList<String> list){
        this.list = list;
    }
}
