package com.revature.roommaintenanceprototype.fragment.trainer.verify.criteria;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;

import java.util.List;

public class TV_CriteriaSelectionAdapter extends RecyclerView.Adapter<TV_CriteriaSelectionAdapter.MyViewHolder>  {

    List<String> criteria;
    Activity activity;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public View parent;
        public Switch aSwitch;
        public NavController navController;

        public MyViewHolder(View v){
            super(v);
            //aSwitch = v.findViewById(R.id.criteria_selection_switch);
        }
    }

    public TV_CriteriaSelectionAdapter(Activity activity, List<String> criteria){
        this.criteria = criteria;
        this.activity = activity;
    }

    @NonNull
    @Override
    public TV_CriteriaSelectionAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.criteria_selection_option, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        vh.parent = parent;
        return vh;
    }

    public void onBindViewHolder(final MyViewHolder holder, final int position){
        //holder.aSwitch.setText(criteria.get(position));
    }

    public int getItemCount() {
        return criteria.size();
    }

}
