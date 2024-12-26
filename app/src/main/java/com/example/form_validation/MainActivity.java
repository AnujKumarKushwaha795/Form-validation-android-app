package com.example.form_validation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button pickImageButton;
    private EditText name, email, password, rePassword;
    private TextView gender,licence;
    private CheckBox checkBox;
    private RadioGroup radioGroup;
    private RadioButton male, female, other;
    private TextView country;
    private Spinner countrySpinner;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views using findViewById
        imageView = findViewById(R.id.imageView);
        pickImageButton = findViewById(R.id.pickImageButton);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        rePassword = findViewById(R.id.rePassword);
        gender = findViewById(R.id.gender);
        licence = findViewById(R.id.licence);
        checkBox = findViewById(R.id.checkBox);
        radioGroup = findViewById(R.id.radioGroup);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        other = findViewById(R.id.other);
        country = findViewById(R.id.country);
        countrySpinner = findViewById(R.id.countrySpinner);
        register = findViewById(R.id.register);

        // Example usage: Set a click listener for the pickImageButton
        pickImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Pick Image Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameText = name.getText().toString();
                String emailText = email.getText().toString();
                String passwordText = password.getText().toString();
                String rePasswordText = rePassword.getText().toString();
                String genderText = "";
                if(male.isChecked()){
                    genderText = "Male";
                } else if (female.isChecked()) {
                    genderText = "Female";
                } else if (other.isChecked()) {
                    genderText = "Other";
                }
                //String countryText = countrySpinner.getSelectedItem().toString();
                boolean licenceChecked = checkBox.isChecked();

                // Create and show the AlertDialog
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Registration Details")
                        .setMessage("Name: " + nameText + "\n" +
                                "Email: " + emailText + "\n" +
                                "Password: " + passwordText + "\n" +
                                "Re-Password: " + rePasswordText + "\n" +
                                "Gender: " + genderText + "\n" +
                                "Licence: " + licenceChecked)
                        .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                        .show();
            }
        });
    }
}