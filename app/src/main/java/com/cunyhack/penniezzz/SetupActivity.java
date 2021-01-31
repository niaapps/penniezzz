package com.cunyhack.penniezzz;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SetupActivity extends AppCompatActivity implements AlarmDialog.AlarmDialogListener, ExampleDialog.ExampleDialogListener, CharityDialog.CharityDialogListener  {

        Button alarmSetup;
        Button donateSetup;
        Button openAlarmButton;
        TimePicker timePicker;
        Spinner interval;
        TextView intervals;
        TextView timeSet;
        String time = "";
        String [] info = new String[5];
        Button charitySetup;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_setup);
        alarmSetup = findViewById(R.id.alarmButton);
        timePicker = findViewById(R.id.timePicker);
        intervals = findViewById(R.id.tv1);
        timeSet = findViewById(R.id.tv2);
        openAlarmButton = findViewById(R.id.openAlarmButton);
        donateSetup = findViewById(R.id.donateButton);
        charitySetup = findViewById(R.id.charityButton);
        String time="";
        String interval = "";

        openAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAlarmActivity();
            }
        });


        alarmSetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogAlarm();
            }
        });

        charitySetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogCharity();
            }
        });

        donateSetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    public void openDialog() {
        ExampleDialog dialog = new ExampleDialog();
        dialog.show(getSupportFragmentManager(), "example dialog");
    }
    public void openDialogAlarm() {
        AlarmDialog dialog = new AlarmDialog();

        dialog.show(getSupportFragmentManager(), "alarm dialog");
    }
    public void openDialogCharity() {
        CharityDialog dialog = new CharityDialog();

        dialog.show(getSupportFragmentManager(), "charity dialog");
    }

    @Override
    public void onYesClicked() {

    }

    @Override
    public void applyTexts(String a) {
        //charity info, pass
    }

    @Override
    public void applyTexts(String a, String b) {

           info = passValues(a,b);
}


    private void openAlarmActivity() {
        String[] v = info;
        String a ="";
        String b = "";
        a = v[0];
        b = v[1];
        Intent intent = new Intent(this, AlarmActivity.class);
        intent.putExtra("time", a);
        intent.putExtra("interval",b);
        startActivity(intent);
    }

    public String [] passValues(String a, String b){
        String [] values = {a,b};
        return values;
    }

}




