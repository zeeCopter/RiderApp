package com.example.ejaaz.riderapp.Registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.ejaaz.riderapp.LoginActivity;
import com.example.ejaaz.riderapp.R;

public class CaptainDashboardActivity extends AppCompatActivity {

    RelativeLayout docStatusRL,traningSlotRL,pdfRL,changeCityRL,bankInfoRL;
    ImageView logoutIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captain_dashboard);

        docStatusRL = findViewById(R.id.docStatusRL);
        traningSlotRL = findViewById(R.id.traningSlotRL);
        pdfRL = findViewById(R.id.pdfRL);
        changeCityRL = findViewById(R.id.changeCityRL);
        bankInfoRL = findViewById(R.id.bankInfoRL);
        logoutIV = findViewById(R.id.logoutIV);

        docStatusRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CaptainDashboardActivity.this,DocumentStatusActivity.class));
            }
        });

        traningSlotRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CaptainDashboardActivity.this,BookTraningSlotActivity.class));
            }
        });

        pdfRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CaptainDashboardActivity.this,BookTraningSlotTwoActicvity.class));
            }
        });

        changeCityRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CaptainDashboardActivity.this,ChangeCityActivity.class));
            }
        });

        bankInfoRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CaptainDashboardActivity.this,BankInfoActivity.class));
            }
        });

        logoutIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CaptainDashboardActivity.this,LoginActivity.class));
                finish();
            }
        });
    }
}
