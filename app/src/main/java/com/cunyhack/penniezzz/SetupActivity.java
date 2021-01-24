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

public class SetupActivity extends AppCompatActivity implements AlarmDialog.AlarmDialogListener, ExampleDialog.ExampleDialogListener  {
        Button alarmSetup;
        Button donateSetup;
        Button openAlarmButton;
        TimePicker timePicker;
        Spinner interval;
        TextView intervals;
        TextView timeSet;
        String time = "";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_setup);
        alarmSetup = findViewById(R.id.alarmButton);
        timePicker = findViewById(R.id.timePicker);
        intervals = findViewById(R.id.tv1);
        timeSet = findViewById(R.id.tv2);
        openAlarmButton = findViewById(R.id.openAlarmButton);

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


//        donateSetup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(SetupActivity.this);
//                View view = getLayoutInflater().inflate(R.layout.donate_dialog_setup, null);
//                builder.setTitle("Configure Donate Settings");
//                ;
//
//                builder.setPositiveButton("save", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                            dialog.dismiss();
//
//                    }
//                });
//
//                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
//                builder.setView(view);
//                AlertDialog dialog = builder.create();
//                dialog.show();
//
//
//
//            }
//        });


    }

    public void openDialog() {
        ExampleDialog dialog = new ExampleDialog();
        dialog.show(getSupportFragmentManager(), "example dialog");
    }
    public void openDialogAlarm() {
        AlarmDialog dialog = new AlarmDialog();

        dialog.show(getSupportFragmentManager(), "alarm dialog");
    }

    @Override
    public void onYesClicked() {

    }

    @Override
    public void applyTexts(String a, String b) {
        timeSet.setText(a);
        intervals.setText(b);
}

    private void openAlarmActivity() {
        Intent intent = new Intent(this, AlarmActivity.class);
        startActivity(intent);
    }

}



