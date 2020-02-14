package com.revature.roommaintenanceprototype.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.util.ScreenMessage;

import java.util.ArrayList;

public class CriteriaAdapter extends RecyclerView.Adapter<CriteriaAdapter.CriteriaViewHolder>{
    ArrayList<String> criteriaItemsList;

    public CriteriaAdapter(ArrayList<String> criteriaItemList){
        this.criteriaItemsList = criteriaItemList;
    }

    @NonNull
    @Override
    public CriteriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_cleaning_criteria, parent, false);
        return new CriteriaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CriteriaViewHolder holder, int position) {
        holder.tvCleaningItem.setText(criteriaItemsList.get(position));
    }

    @Override
    public int getItemCount() {
        return criteriaItemsList.size();
    }

    class CriteriaViewHolder extends RecyclerView.ViewHolder{
        Switch swtCleaningItem;
        TextView tvCleaningItem;

        public CriteriaViewHolder(@NonNull final View itemView) {
            super(itemView);
            tvCleaningItem = itemView.findViewById(R.id.tv_cleaningCriteria_item);

            swtCleaningItem = (Switch) itemView.findViewById(R.id.swt_cleaningCriteria_item);
            swtCleaningItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    ScreenMessage.snackBarLongMsg(itemView,tvCleaningItem.getText().toString());
                }
            });
        }
    }
}