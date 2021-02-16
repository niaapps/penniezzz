package com.cunyhack.penniezzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
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
    TextView alarmL;
    Button wakeUp;
    Button payUp;
    Button configureSettings;
    long interval;
    String alarmTime = "";
    String alarmInterval ="";
    String amount ="";
    String org = "";
    boolean running = true;
    CountDownTimer intervalTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        Intent intent = getIntent();
        alarmTime = intent.getStringExtra("time");
        alarmInterval = intent.getStringExtra("interval");
        amount = intent.getStringExtra("donation");
        org = intent.getStringExtra("organization");

//        Finds the ID of the currentTime TextClock
        currentTime = findViewById(R.id.currentTime);
//        Finds the ID of the the wakeUp Button and the payUp Button
        wakeUp = findViewById(R.id.wakeUp);
        payUp =  findViewById(R.id.payUp);
        configureSettings = findViewById(R.id.configureSettingsButton);
        alarmSet = findViewById(R.id.alarmTimeSet);
        alarmL = findViewById(R.id.alarmlabel);
        final Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(),RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));

        alarmSet.setText(alarmTime);

        if(alarmInterval== null ||  alarmTime.isEmpty()){
            alarmL.setText("No alarm scheduled");

        }else{
            alarmL.setText(R.string.alarmL);
            interval = getInterval(alarmInterval);
            Timer timer = new Timer();
            long i = interval;
            timer.scheduleAtFixedRate(new TimerTask() {

                @Override
                public void run() {
                    if(currentTime.getText().toString().equals(alarmTime) && running){
                        runOnUiThread(new Runnable() {
                                          public void run() {

                                              running =  startTimer(i);
                                              if(running) {
                                                  ringtone.play();
                                              }else{
                                                  pauseTimer();
                                                  ringtone.stop();
                                              }


                                          }
                                      }
                        );

                    }else if(currentTime.getText().toString().equals(alarmTime) && !running){
                        ringtone.stop();
                        boolean once = true;
                        do{
                            if(!running){
                                openDonationRequestActivity();
                                once = false;
                            }
                        }while (!once);


                    }


                }



            },0, 1000 );
        }



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
                pauseTimer();
                ringtone.stop();
                congratText.setText("Good Morning!");
            }
        });

        payUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseTimer();
                ringtone.stop();
                openDonationRequestActivity();


            }
        });



    }

    private void openDonationRequestActivity() {
        Intent intent = new Intent(this, DonationRequestActivity.class);
        intent.putExtra("organization",org);
        intent.putExtra("donation",amount);
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
                i = 30000;
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



    private boolean startTimer(long i) {
        intervalTimer = new CountDownTimer(i, 1000) {
            volatile long interval = i;
            @Override
            public void onTick(long millisUntilFinished) {
                interval = millisUntilFinished;

            }
            @Override
            public void onFinish() {
                running = false;
                pauseTimer();
                intervalTimer.cancel();


            }
        }.start();


        return running;

    }
    private void pauseTimer() {
        intervalTimer.cancel();
        running = false;
    }



}