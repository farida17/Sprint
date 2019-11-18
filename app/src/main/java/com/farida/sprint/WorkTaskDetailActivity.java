package com.farida.sprint;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

import static com.farida.sprint.WorkTaskListFragment.workTasks;


public class WorkTaskDetailActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private TextView dateText;

    public static final String EXTRA_WORK_ID = "workTaskId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_task_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        dateText = findViewById(R.id.date_text);

        findViewById(R.id.show_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        int workTaskId = (Integer)getIntent().getExtras().get(EXTRA_WORK_ID);
        String workTaskName = workTasks.get(workTaskId).getName();
        TextView textView1 = (TextView)findViewById(R.id.home_text1);
        textView1.setText(workTaskName);
        String workTasKRecommendation = workTasks.get(workTaskId).getRecommendation();
        TextView textView2 = (TextView)findViewById(R.id.home_text2);
        textView2.setText(workTasKRecommendation);
        int workTaskImage = workTasks.get(workTaskId).getImage();
        ImageView imageView = (ImageView)findViewById(R.id.home_picture);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, workTaskImage));
        imageView.setContentDescription(workTaskName);
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
        String date = "month/day/year: " + month + "/" + dayOfMonth + "/" + year;
        dateText.setText(date);
    }
}
