package com.cunyhack.penniezzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class DonationRequestActivity extends AppCompatActivity {

    Button confirmButton;
    Button declineButton;
    String amount ="";
    String org = "";
    TextView donate;
    TextView organization;
    double dollars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_request);

        confirmButton = findViewById(R.id.confirmButton);
        declineButton = findViewById(R.id.declineButton);
        donate = findViewById(R.id.donationAmount);
        organization = findViewById(R.id.charitySelection);

        Intent intent = getIntent();
        amount = intent.getStringExtra("donation");
        dollars = convertToInt(amount);
        amount = "$"+ amount;
        org = intent.getStringExtra("organization");

        donate.setText(amount);
        organization.setText(org);


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

    public double convertToInt(String i){
        double d = Double.valueOf(i.trim());
        return d;
    }
}
