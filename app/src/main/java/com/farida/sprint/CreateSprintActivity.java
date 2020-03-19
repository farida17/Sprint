package com.farida.sprint;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;

public class CreateSprintActivity extends LifecycleDaggerActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    //public static final String EXTRA_SPRINTTASK_ID = "sprintTaskId";

    private CreateSprintViewModel viewModel;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    @BindView(R.id.daysOfMonth)
    ChipGroup daysOfMonth;
    @BindView(R.id.show_startDate)
    TextView sDate;
    @BindView(R.id.show_finishDate)
    TextView fDate;
    @BindView(R.id.notifyTime)
    Button nTime;

    private TextView sprintTaskName;
    private TextView taskRecommendation;
    private boolean isFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_sprint);
        ButterKnife.bind(this);


        /*for (int i = 0; i < daysOfMonth.getChildCount(); i++) {
            Chip childAt = (Chip) daysOfMonth.getChildAt(i);
            childAt.setOnCheckedChangeListener((buttonView, isChecked) -> {
                System.out.println(getSelectedDaysOfWeek());
            });
        }*/

        findViewById(R.id.show_startDate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFinish = false;
                showDatePickerDialog();
            }
        });

        findViewById(R.id.show_finishDate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFinish = true;
                showDatePickerDialog();
            }
        });

        findViewById(R.id.notifyTime).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });
    }


    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = dayOfMonth + "/" + month + "/" + year;
        if(!isFinish) {
            sDate.setText(date);
        } else {
            fDate.setText(date);
        }
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
                Calendar.getInstance().get(Calendar.MINUTE),
                true
        );
        timePickerDialog.show();
    }
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        String time = hourOfDay + ":" + minute;
        nTime.setText(time);
    }

    private List<Integer> getSelectedDaysOfWeek() {
        List<Integer> result = new ArrayList<>(daysOfMonth.getChildCount());
        for (int i = 0; i < daysOfMonth.getChildCount(); i++) {
            Chip childAt = (Chip) daysOfMonth.getChildAt(i);
            if (childAt.isChecked()) {
                result.add(i);
            }
        }
        return result;
    }
}

