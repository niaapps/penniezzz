package com.cunyhack.penniezzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DonationRequestActivity extends AppCompatActivity {

    Button confirmButton;
    Button declineButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_request);

        confirmButton = findViewById(R.id.confirmButton);
        declineButton = findViewById(R.id.declineButton);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openThankYouActivity();
            }
        });

        declineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToAlarmActivity();
            }
        });
    }

    private void openThankYouActivity() {
        Intent intent = new Intent(this, ThankYouActivity.class);
        startActivity(intent);
    }

    private void backToAlarmActivity() {
        Intent intent = new Intent(this, AlarmActivity.class);
        startActivity(intent);
    }
}