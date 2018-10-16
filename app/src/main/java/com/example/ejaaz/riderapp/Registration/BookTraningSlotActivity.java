package com.example.ejaaz.riderapp.Registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.ejaaz.riderapp.R;

public class BookTraningSlotActivity extends AppCompatActivity {

    ImageView backIV;
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_traning_slot);

        backIV = findViewById(R.id.backIV);
        nextBtn = findViewById(R.id.nextBtn);

        backIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BookTraningSlotActivity.this,BookTraningSlotTwoActicvity.class));
                finish();
            }
        });
    }
}
