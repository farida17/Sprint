package com.farida.sprint;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class HealthTaskDetailActivity extends AppCompatActivity {

    public static final String EXTRA_HEALTH_ID = "healthId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_task_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        int healthId = (Integer)getIntent().getExtras().get(EXTRA_HEALTH_ID);
        String healthName = HealthTask.healthLists[healthId].getName();
        TextView textView = (TextView)findViewById(R.id.health_text);
        textView.setText(healthName);
        int healthImage = HealthTask.healthLists[healthId].getImage();
        ImageView imageView = (ImageView)findViewById(R.id.health_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, healthImage));
        imageView.setContentDescription(healthName);
    }
}
