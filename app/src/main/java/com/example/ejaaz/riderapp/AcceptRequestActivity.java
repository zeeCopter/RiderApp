package com.example.ejaaz.riderapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ejaaz.riderapp.Utils.CommonUtils;

import java.util.Timer;
import java.util.TimerTask;

public class AcceptRequestActivity extends AppCompatActivity {

    int timer = 0;
    ImageView countOneIV,countTwoIV,countThreeIV,countFourIV,countFiveIV,countSixIV,countSevenIV,countEightIV,countNineIV,countTenIV;
    TextView timerTV;
    Timer t;
    Button rejectBtn,acceptBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept_reject_request);

        countOneIV = findViewById(R.id.countOneIV);
        countTwoIV = findViewById(R.id.countTwoIV);
        countThreeIV = findViewById(R.id.countThreeIV);
        countFourIV = findViewById(R.id.countFourIV);
        countFiveIV = findViewById(R.id.countFiveIV);
        countSixIV = findViewById(R.id.countSixIV);
        countSevenIV = findViewById(R.id.countSevenIV);
        countEightIV = findViewById(R.id.countEightIV);
        countNineIV = findViewById(R.id.countNineIV);
        countTenIV = findViewById(R.id.countTenIV);

        timerTV = findViewById(R.id.timerTV);

        rejectBtn = findViewById(R.id.rejectBtn);
        acceptBtn = findViewById(R.id.acceptBtn);

        t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(timer == 11)
                        {
                            t.cancel();
                            finish();
                        }
                        else
                            setIndicators(timer++);
                    }
                });
            }

        }, 0, 1000);

        acceptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommonUtils.acceptOrRejectState = 1;
                finish();
            }
        });

        rejectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommonUtils.acceptOrRejectState = 0;
                finish();
            }
        });

    }

    private void setIndicators(int time)
    {
        timerTV.setText(time+" Sec");
        if(time == 1)
            countOneIV.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        if(time == 2)
            countTwoIV.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        if(time == 3)
            countThreeIV.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        if(time == 4)
            countFourIV.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        if(time == 5)
            countFiveIV.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        if(time == 6)
            countSixIV.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        if(time == 7)
            countSevenIV.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        if(time == 8)
            countEightIV.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        if(time == 9)
            countNineIV.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        if(time == 10)
            countTenIV.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
    }
}
