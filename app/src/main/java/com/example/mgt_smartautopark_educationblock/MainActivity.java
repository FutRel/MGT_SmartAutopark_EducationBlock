package com.example.mgt_smartautopark_educationblock;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

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

        // Обработчики для кнопок входа
        findViewById(R.id.normal_login_button).setOnClickListener(v -> {
            // Интент обычного входа
        });

        findViewById(R.id.admin_login_button).setOnClickListener(v -> {
            // Интент админского входа
        });
    }
}