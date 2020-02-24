package com.revature.roommaintenanceprototype.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.util.fragmenthelpers.FragmentHelper;

import java.util.ArrayList;
import java.util.List;

public class CriteriaAdapter extends RecyclerView.Adapter<CriteriaAdapter.CriteriaViewHolder>{
    private ArrayList<String> criteriaItemsList;
    private OnItemClickListener listener;
    private OnChangeSwitchState switchListener;
    private ArrayList<String> selectedCriteriaList;

    public CriteriaAdapter(ArrayList<String> criteriaItemList,OnItemClickListener listener,OnChangeSwitchState switchListener){
        this.criteriaItemsList = criteriaItemList;
        this.switchListener = switchListener;
        this.listener = listener;
    }

    public CriteriaAdapter(ArrayList<String> criteriaItemList,OnItemClickListener listener,OnChangeSwitchState switchListener,ArrayList<String> selectedCriteriaList){
        this.criteriaItemsList = criteriaItemList;
        this.switchListener = switchListener;
        this.listener = listener;
        this.selectedCriteriaList = selectedCriteriaList;
    }

    public ArrayList<String> getSelectedCriteriaList() {
        return selectedCriteriaList;
    }

    @NonNull
    @Override
    public CriteriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_cleaning_criteria, parent, false);
        return new CriteriaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CriteriaViewHolder holder, final int position) {
        TextView tvTitle = holder.tvCleaningItem;
        tvTitle.setText(criteriaItemsList.get(position));
        String title = tvTitle.getText().toString();
        if( selectedCriteriaList.contains(title) ){
            holder.swtCleaningItem.setChecked(true);
        }else{
            holder.swtCleaningItem.setChecked(false);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                listener.onItemClick(view, 0);
            }
        });
        holder.swtCleaningItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switchListener.onSwitchChanged(holder.tvCleaningItem.getText().toString(),buttonView,isChecked);
            }
        });
        FragmentHelper.restoreCriteriaChoices(holder.container,selectedCriteriaList);
    }

    @Override
    public int getItemCount() {
        return criteriaItemsList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    class CriteriaViewHolder extends RecyclerView.ViewHolder{
        Switch swtCleaningItem;
        TextView tvCleaningItem;
        LinearLayout container;

        public CriteriaViewHolder(@NonNull final View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.linearLayout);
            tvCleaningItem = itemView.findViewById(R.id.tv_cleaningCriteria_item);
            swtCleaningItem = (Switch) itemView.findViewById(R.id.swt_cleaningCriteria_item);
            this.setIsRecyclable(false);
        }
    }

    public void updateList(ArrayList<String> list){
        this.criteriaItemsList = list;
    }
}