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

public class AlarmActivity extends AppCompatActivity {

    TextClock currentTime;
    TextView congratText;
    Button wakeUp;
    Button payUp;
    Button configureSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
//        Finds the ID of the currentTime TextClock
        currentTime = findViewById(R.id.currentTime);
//        Finds the ID of the the wakeUp Button and the payUp Button
        wakeUp = findViewById(R.id.wakeUp);
//        payUp =  findViewById(R.id.payUp);
        configureSettings = findViewById(R.id.configureSettingsButton);
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


        final Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));


    }

    private void openSetupActivity() {
        Intent intent = new Intent(this, SetupActivity.class);
        startActivity(intent);
    }
}