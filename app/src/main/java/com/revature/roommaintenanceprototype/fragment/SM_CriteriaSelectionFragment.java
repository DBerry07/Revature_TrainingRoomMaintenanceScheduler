package com.revature.roommaintenanceprototype.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.revature.roommaintenanceprototype.R;
import com.revature.roommaintenanceprototype.util.DummyText;
import com.revature.roommaintenanceprototype.util.FragmentStringTags;
import com.revature.roommaintenanceprototype.util.ScreenMessage;

import java.util.ArrayList;

public class SM_CriteriaSelectionFragment extends Fragment {
    Button btnCleaningCriteriaSelection;
    RecyclerView rvCleaningCriteria;

    public SM_CriteriaSelectionFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_criteria_selection, container, false);

        rvCleaningCriteria = (RecyclerView) rootView.findViewById(R.id.rv_cleaningCriteria);
        rvCleaningCriteria.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvCleaningCriteria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScreenMessage.toastShortMsg(getContext(),"Clicked on RVs");
            }
        });
        rvCleaningCriteria.setAdapter( new CriteriaAdapter( (ArrayList<String>) DummyText.getCleaningCriteria() ) );
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        btnCleaningCriteriaSelection = (Button) view.findViewById(R.id.btn_cleaningCriteriaSelection);
        btnCleaningCriteriaSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_mainContentContainer, new SM_TrainerSelectionFragment(), FragmentStringTags.getSM_TrainerSelectionFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

    }

    private class CriteriaAdapter extends RecyclerView.Adapter<CriteriaAdapter.CriteriaViewHolder>{
        ArrayList<String> criteriaItemsList;

        CriteriaAdapter(ArrayList<String> criteriaItemList){
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

        private class CriteriaViewHolder extends RecyclerView.ViewHolder{
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

}
