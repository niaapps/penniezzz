package com.cunyhack.penniezzz;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SetupActivity extends AppCompatActivity {
        Button alarmSetup;
        Button donateSetup;
        TimePicker timePicker;
        Spinner interval;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_setup);
        alarmSetup = findViewById(R.id.alarmButton);

//        alarmSetup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(SetupActivity.this);
//                View view = getLayoutInflater().inflate(R.layout.alarm_dialog_setup, null);
//                builder.setTitle("Configure Alarm Settings");
//                interval = view.findViewById(R.id.intervalSpinner);
//
//                ArrayAdapter<String> adapter = new ArrayAdapter<String>(SetupActivity.this,
//                        android.R.layout.simple_spinner_item,
//                        getResources().getStringArray(R.array.intervals));
//
//                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                interval.setAdapter(adapter);
//
//                builder.setPositiveButton("save", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        if (!interval.getSelectedItem().toString().equalsIgnoreCase("Select a Tone")) {
//                            // give info to go to prev screen
//                            String choice = interval.getSelectedItem().toString();
//
//
//                            dialog.dismiss();
//                        }
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

        alarmSetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SetupActivity.this);
                View view = getLayoutInflater().inflate(R.layout.donate_dialog_setup, null);
                builder.setTitle("Configure Donate Settings");
                ;

                builder.setPositiveButton("save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                            dialog.dismiss();

                    }
                });

                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();



            }
        });



    }
}
