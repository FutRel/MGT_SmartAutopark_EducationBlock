package com.example.mgt_smartautopark_educationblock;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private LinearLayout normalLoginForm;
    private LinearLayout adminLoginForm;
    private Button switchToAdminButton;
    private Button switchToNormalButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        normalLoginForm = findViewById(R.id.normal_login_form);
        adminLoginForm = findViewById(R.id.admin_login_form);
        switchToAdminButton = findViewById(R.id.switch_to_admin_button);
        switchToNormalButton = findViewById(R.id.switch_to_normal_button);

        switchToAdminButton.setOnClickListener(v -> {
            normalLoginForm.setVisibility(View.GONE);
            adminLoginForm.setVisibility(View.VISIBLE);
            switchToAdminButton.setVisibility(View.GONE);
        });

        switchToNormalButton.setOnClickListener(v -> {
            adminLoginForm.setVisibility(View.GONE);
            normalLoginForm.setVisibility(View.VISIBLE);
            switchToAdminButton.setVisibility(View.VISIBLE);
        });

        findViewById(R.id.normal_login_button).setOnClickListener(v -> { // Обработчик для обычного входа
            EditText lastNameInput = findViewById(R.id.last_name_input);
            EditText firstNameInput = findViewById(R.id.first_name_input);
            EditText middleNameInput = findViewById(R.id.middle_name_input);
            EditText employeeIdInput = findViewById(R.id.employee_id_input);

            String lastName = lastNameInput.getText().toString().trim();
            String firstName = firstNameInput.getText().toString().trim();
            String middleName = middleNameInput.getText().toString().trim();
            String employeeId = employeeIdInput.getText().toString().trim();

            if (lastName.isEmpty() || firstName.isEmpty() || middleName.isEmpty() || employeeId.isEmpty()) {
                Toast.makeText(this, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(this, VideoListActivity.class);
            intent.putExtra("lastName", lastName);
            intent.putExtra("firstName", firstName);
            intent.putExtra("middleName", middleName);
            intent.putExtra("employeeId", employeeId);
            startActivity(intent);
        });


        findViewById(R.id.admin_login_button).setOnClickListener(v -> { // Обработчик для админского ахода
            EditText adminLoginInput = findViewById(R.id.admin_login_input);
            EditText adminPasswordInput = findViewById(R.id.admin_password_input);

            String login = adminLoginInput.getText().toString().trim();
            String password = adminPasswordInput.getText().toString().trim();

            if (login.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(this, VideoListActivity.class);
            intent.putExtra("login", login);
            intent.putExtra("password", password);
            startActivity(intent);
        });
    }
}