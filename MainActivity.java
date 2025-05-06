package com.example.resgistration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText nameEditText;
    Spinner subjectSpinner;
    RadioGroup genderRadioGroup;
    CheckBox graduateCheckBox, postGraduateCheckBox, diplomaCheckBox;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        subjectSpinner = findViewById(R.id.subjectSpinner);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        graduateCheckBox = findViewById(R.id.graduateCheckBox);
        postGraduateCheckBox = findViewById(R.id.postGraduateCheckBox);
        diplomaCheckBox = findViewById(R.id.diplomaCheckBox);
        submitButton = findViewById(R.id.submitButton);

        // Set up the spinner
        String[] subjects = {"JAVA", "OS", "History", "Computer Science", "DSA"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, subjects);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subjectSpinner.setAdapter(adapter);

        // On Submit Click
        submitButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString().trim();
            if (name.isEmpty() || !name.matches("[a-zA-Z ]+")) {
                nameEditText.setError("Enter a valid name");
                return;
            }

            String subject = subjectSpinner.getSelectedItem().toString();
            int selectedId = genderRadioGroup.getCheckedRadioButtonId();
            String gender = selectedId != -1 ? ((RadioButton) findViewById(selectedId)).getText().toString() : "Not Selected";

            StringBuilder qualifications = new StringBuilder();
            if (graduateCheckBox.isChecked()) qualifications.append("Graduate ");
            if (postGraduateCheckBox.isChecked()) qualifications.append("Post Graduate ");
            if (diplomaCheckBox.isChecked()) qualifications.append("Diploma ");
            if (qualifications.length() == 0) qualifications.append("None");

            // Start ShowActivity
            Intent intent = new Intent(MainActivity.this, ShowActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("subject", subject);
            intent.putExtra("gender", gender);
            intent.putExtra("qualifications", qualifications.toString());
            startActivity(intent);
        });
    }
}
