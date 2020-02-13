package com.revature.roommaintenanceprototype.fragment.trainer.delegate.date;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.revature.roommaintenanceprototype.R;

public class TD_DateSelecterFragment extends Fragment {

    private int sYear;
    private int sMonth;
    private int sDay;

    private int eYear;
    private int eMonth;
    private int eDay;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Toast.makeText(getContext(), "StartDate", Toast.LENGTH_LONG);
        final View rootView =
                inflater.inflate(R.layout.fragment_date_selector, container, false);

        Button startDateBtn = rootView.findViewById(R.id.date_selector_start_btn);
        Button endDateBtn = rootView.findViewById(R.id.date_selector_end_btn);
        Button submit = rootView.findViewById(R.id.date_selecter_submit_btn);

        startDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "StartDate", Toast.LENGTH_LONG);
                final Calendar calendar = Calendar.getInstance();
                sYear = calendar.get(Calendar.YEAR);
                sMonth = calendar.get(Calendar.MONTH);
                sDay = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dpd = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                TextView tv = rootView.findViewById(R.id.tv_start_date);
                                tv.setText(month + "/" + dayOfMonth + "/" + year);
                            }
                        }, sYear, sMonth, sDay);
                dpd.show();
            }
        });

        endDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "EndDate", Toast.LENGTH_LONG);
                final Calendar calendar = Calendar.getInstance();
                eYear = calendar.get(Calendar.YEAR);
                eMonth = calendar.get(Calendar.MONTH);
                eDay = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dpd = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                TextView tv = rootView.findViewById(R.id.tv_end_date);
                                tv.setText(month + "/" + dayOfMonth + "/" + year);
                            }
                        }, eYear, eMonth, eDay);
                dpd.show();
            }
        });

        return rootView;
    }

}
