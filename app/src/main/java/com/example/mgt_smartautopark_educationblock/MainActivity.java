package com.example.mgt_smartautopark_educationblock;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private LinearLayout normalLoginForm, adminLoginForm;
    private Button switchToAdminButton, switchToNormalButton;
    private Button normalLoginButton, adminLoginButton;

    private EditText lastNameInput, firstNameInput, middleNameInput, employeeIdInput;
    private EditText adminLoginInput, adminPasswordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        normalLoginForm = findViewById(R.id.normal_login_form);
        adminLoginForm = findViewById(R.id.admin_login_form);
        switchToAdminButton = findViewById(R.id.switch_to_admin_button);
        switchToNormalButton = findViewById(R.id.switch_to_normal_button);

        //Обычный вход
        lastNameInput = findViewById(R.id.last_name_input);
        firstNameInput = findViewById(R.id.first_name_input);
        middleNameInput = findViewById(R.id.middle_name_input);
        employeeIdInput = findViewById(R.id.employee_id_input);
        normalLoginButton = findViewById(R.id.normal_login_button);

        //Админский вход
        adminLoginInput = findViewById(R.id.admin_login_input);
        adminPasswordInput = findViewById(R.id.admin_password_input);
        adminLoginButton = findViewById(R.id.admin_login_button);

        // Изначально отключаем кнопки
        normalLoginButton.setEnabled(false);
        adminLoginButton.setEnabled(false);

        //Обычный наблюдатель
        TextWatcher normalWatcher = new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override public void afterTextChanged(Editable s) {
                boolean filled = !lastNameInput.getText().toString().trim().isEmpty() &&
                        !firstNameInput.getText().toString().trim().isEmpty() &&
                        !middleNameInput.getText().toString().trim().isEmpty() &&
                        !employeeIdInput.getText().toString().trim().isEmpty();

                normalLoginButton.setEnabled(filled);
            }
        };

        //Админский наблюдатель
        TextWatcher adminWatcher = new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override public void afterTextChanged(Editable s) {
                boolean filled = !adminLoginInput.getText().toString().trim().isEmpty() &&
                        !adminPasswordInput.getText().toString().trim().isEmpty();

                adminLoginButton.setEnabled(filled);
            }
        };

        // Применяем наблюдатели
        lastNameInput.addTextChangedListener(normalWatcher);
        firstNameInput.addTextChangedListener(normalWatcher);
        middleNameInput.addTextChangedListener(normalWatcher);
        employeeIdInput.addTextChangedListener(normalWatcher);

        adminLoginInput.addTextChangedListener(adminWatcher);
        adminPasswordInput.addTextChangedListener(adminWatcher);

        // Переключение форм
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

        // Кнопка обычного входа
        normalLoginButton.setOnClickListener(v -> {
            String lastName = lastNameInput.getText().toString().trim();
            String firstName = firstNameInput.getText().toString().trim();
            String middleName = middleNameInput.getText().toString().trim();
            String employeeId = employeeIdInput.getText().toString().trim();

            if (!lastName.isEmpty() && !firstName.isEmpty() &&!middleName.isEmpty() &&!employeeId.isEmpty()){
                Intent intent = new Intent(this, VideoListActivity.class);
                intent.putExtra("lastName", lastName);
                intent.putExtra("firstName", firstName);
                intent.putExtra("middleName", middleName);
                intent.putExtra("employeeId", employeeId);
                startActivity(intent);
            }
            else Toast.makeText(this, "Не все данные введены", Toast.LENGTH_SHORT).show();
        });

        // Кнопка админского входа
        adminLoginButton.setOnClickListener(v -> {
            String login = adminLoginInput.getText().toString().trim();
            String password = adminPasswordInput.getText().toString().trim();

            if (!login.isEmpty() && !password.isEmpty()){
                Intent intent = new Intent(this, VideoListActivity.class);
                intent.putExtra("login", login);
                intent.putExtra("password", password);
                startActivity(intent);
            }
            else Toast.makeText(this, "Не все данные введены", Toast.LENGTH_SHORT).show();
        });
    }
}
