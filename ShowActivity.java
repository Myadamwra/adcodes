package com.example.resgistration;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ShowActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        TextView showDataTextView = findViewById(R.id.showDataTextView);

        String name = getIntent().getStringExtra("name");
        String subject = getIntent().getStringExtra("subject");
        String gender = getIntent().getStringExtra("gender");
        String qualifications = getIntent().getStringExtra("qualifications");

        String displayText = "Name: " + name + "\n"
                + "Subject: " + subject + "\n"
                + "Gender: " + gender + "\n"
                + "Qualifications: " + qualifications;

        showDataTextView.setText(displayText);
    }
}
