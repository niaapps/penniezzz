package com.cunyhack.penniezzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class AlarmActivity extends AppCompatActivity {

    TextClock currentTime;
    TextView congratText;
    TextView alarmSet;
    Button wakeUp;
    Button payUp;
    Button configureSettings;
    long interval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        Intent intent = getIntent();
        String alarmTime = intent.getStringExtra("time");
        String alarmInterval = intent.getStringExtra("interval");


//        Finds the ID of the currentTime TextClock
        currentTime = findViewById(R.id.currentTime);
//        Finds the ID of the the wakeUp Button and the payUp Button
        wakeUp = findViewById(R.id.wakeUp);
        payUp =  findViewById(R.id.payUp);
        configureSettings = findViewById(R.id.configureSettingsButton);
        alarmSet = findViewById(R.id.alarmTimeSet);
        alarmSet.setText(alarmTime);

        if(alarmInterval== null){
            interval = 1000;
            runAlarm(interval, alarmTime, currentTime);

        }else{ interval = getInterval(alarmInterval); }



        configureSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSetupActivity();
            }
        });

        congratText = findViewById(R.id.congratText);
//        Now we need to listen on the button clicks
        wakeUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                congratText.setText("Good Morning!");
            }
        });

        payUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDonationRequestActivity();
            }
        });


        final Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));


    }

    private void openDonationRequestActivity() {
      Intent intent = new Intent(this, DonationRequestActivity.class);
      startActivity(intent);
    };

    private void openSetupActivity() {
        Intent intent = new Intent(this, SetupActivity.class);
        startActivity(intent);
    }

    public long getInterval(String intv){
        long i = 0;
        switch (intv){
            case "30 seconds":
                i = 2000;
                break;
            case "1 minute":
                i = 60000;
                break;
            case "1 min 30s":
                i = 90000;
                break;
            case "2 minutes":
                i = 120000;
                break;
            case "2 mins 30s":
                i = 150000;
                break;
            case "3 minutes":
                i = 180000;
                break;
            default: i = 5000;
            break;

        }
        return i;
    }

    public void runAlarm(long i, String t, TextClock tc){
        final Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(),RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(tc.getText().toString().equals(t)){
                    ringtone.play();
                } else{ringtone.stop();}
            }
        },0, i );
    }
}