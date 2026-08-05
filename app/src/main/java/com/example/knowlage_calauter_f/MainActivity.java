package com.example.knowlage_calauter_f;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText et10New, et25New, et50New, et100New, et200New, et500New;
    private EditText etPercentage, etAmountPerStudent;
    private TextView tvInstituteShare, tvTeacherShare, tvTotal, tvStudentsCount;
    private Button btnCalculate, btnSave, btnReset;

    private static final double DEFAULT_PERCENTAGE = 35.0;
    private static final int DEFAULT_STUDENTS = 200;

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

        bindViews();
        setupListeners();
    }

    private void bindViews() {
        et10New = findViewById(R.id.input_new_10);
        et25New = findViewById(R.id.input_new_25);
        et50New = findViewById(R.id.input_new_50);
        et100New = findViewById(R.id.input_new_100);
        et200New = findViewById(R.id.input_new_200);
        et500New = findViewById(R.id.input_new_500);

        etPercentage = findViewById(R.id.editTextNumber5);
        etAmountPerStudent = findViewById(R.id.amountPerStudent);

        tvInstituteShare = findViewById(R.id.textView);
        tvTeacherShare = findViewById(R.id.textView7);
        tvTotal = findViewById(R.id.titleTextView);
        tvStudentsCount = findViewById(R.id.studentsCount);

        btnCalculate = findViewById(R.id.cala_bt);
        btnSave = findViewById(R.id.save_bt);
        btnReset = findViewById(R.id.reset_bt);
    }

    private void setupListeners() {
        btnCalculate.setOnClickListener(v -> calculate());
        btnSave.setOnClickListener(v -> saveData());
        btnReset.setOnClickListener(v -> resetAll());
    }

    private void calculate() {
        int val10 = parseIntOrDefault(et10New, 0);
        int val25 = parseIntOrDefault(et25New, 0);
        int val50 = parseIntOrDefault(et50New, 0);
        int val100 = parseIntOrDefault(et100New, 0);
        int val200 = parseIntOrDefault(et200New, 0);
        int val500 = parseIntOrDefault(et500New, 0);

        double percentage = parseDoubleOrDefault(etPercentage, DEFAULT_PERCENTAGE);
        int studentAmount = parseIntOrDefault(etAmountPerStudent, DEFAULT_STUDENTS);

        double total = val10 * 10.0 + val25 * 25.0 + val50 * 50.0
                + val100 * 100.0 + val200 * 200.0 + val500 * 500.0;

        double teacherRatio = (100.0 - percentage) /  100.0;
        double instituteRatio = percentage / 100.0;

        double teacherShareValue = total * teacherRatio;
        double instituteShareValue = total * instituteRatio;

        tvTeacherShare.setText(String.format("%.2f", teacherShareValue));
        tvInstituteShare.setText(String.format("%.2f", instituteShareValue));
        tvTotal.setText(String.valueOf(total));
        tvStudentsCount.setText(String.format("%.2f", total / studentAmount));
    }

    private void resetAll() {
        EditText[] inputs = {et10New, et25New, et50New, et100New, et200New, et500New,
                etPercentage, etAmountPerStudent};
        for (EditText input : inputs) {
            input.setText("");
        }

        tvInstituteShare.setText("للمعهد");
        tvTeacherShare.setText("للاستاذ");
        tvTotal.setText("المجموع الكلي");
        tvStudentsCount.setText("0");
    }

    private void saveData() {
    }

    private int parseIntOrDefault(EditText editText, int defaultValue)
    {
        if (editText == null) return defaultValue;
        String text = editText.getText().toString().trim();
        if (text.isEmpty()) return defaultValue;
        try
        {
            return Integer.parseInt(text);
        }
        catch (NumberFormatException e)
        {
            return defaultValue;
        }
    }

    private double parseDoubleOrDefault(EditText editText, double defaultValue)
    {
        if (editText == null) return defaultValue;
        String text = editText.getText().toString().trim();
        if (text.isEmpty()) return defaultValue;
        try
        {
            return Double.parseDouble(text);
        }
        catch (NumberFormatException e)
        {
            return defaultValue;
        }
    }
}