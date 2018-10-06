package com.example.ejaaz.riderapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DocumentStatusActivity extends AppCompatActivity {

    ImageView backIV;
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_status);

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
                startActivity(new Intent(DocumentStatusActivity.this,UploadDocumentsActivity.class));
                finish();
            }
        });
    }
}
