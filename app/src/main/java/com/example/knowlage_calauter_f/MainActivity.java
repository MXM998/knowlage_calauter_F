package com.example.knowlage_calauter_f;

import android.annotation.SuppressLint;
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

    int old_five_t, old_tow_t, old_one_t, old_five_h;
    int new_10_val, new_25_val, new_50_val, new_100_val, new_200_val, new_500_val;
    int stu_count = 0;

    EditText old_5000, old_2000, old_1000, old_500;
    EditText new_10, new_25, new_50, new_100, new_200, new_500;
    EditText pasnger, stu_countEdit;

    double pasnger_nu;

    TextView step, mxm, mainresult, stu_count_Ui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            ins();
            return insets;
        });
    }

    private void ins() {
        old_5000 = findViewById(R.id.input_5000);
        old_2000 = findViewById(R.id.input_2000);
        old_1000 = findViewById(R.id.input_1000);
        old_500 = findViewById(R.id.input_500);
        new_10 = findViewById(R.id.input_new_10);
        new_25 = findViewById(R.id.input_new_25);
        new_50 = findViewById(R.id.input_new_50);
        new_100 = findViewById(R.id.input_new_100);
        new_200 = findViewById(R.id.input_new_200);
        new_500 = findViewById(R.id.input_new_500);

        pasnger = findViewById(R.id.editTextNumber5);
        stu_countEdit = findViewById(R.id.amountPerStudent);

        Button ccl = findViewById(R.id.cala_bt);
        Button sav_cl = findViewById(R.id.save_bt);
        Button r_ui = findViewById(R.id.reset_bt);

        step = findViewById(R.id.textView);
        mxm = findViewById(R.id.textView7);
        mainresult = findViewById(R.id.titleTextView);
        stu_count_Ui = findViewById(R.id.studentsCount);

        ccl.setOnClickListener(v1 -> Calaut());
        sav_cl.setOnClickListener(view -> save_data());
        r_ui.setOnClickListener(v -> Rest_UI());
    }

    private void rest_value() {
        old_five_t = old_tow_t = old_one_t = old_five_h = 0;
        new_10_val = new_25_val = new_50_val = new_100_val = new_200_val = new_500_val = 0;
        pasnger_nu = 0;
    }

    @SuppressLint("SetTextI18n")
    private void Calaut() {
        rest_value();

        if (isNotEmpty(old_5000)) {
            old_five_t = Integer.parseInt(old_5000.getText().toString());
        }
        if (isNotEmpty(old_2000)) {
            old_tow_t = Integer.parseInt(old_2000.getText().toString());
        }
        if (isNotEmpty(old_1000)) {
            old_one_t = Integer.parseInt(old_1000.getText().toString());
        }
        if (isNotEmpty(old_500)) {
            old_five_h = Integer.parseInt(old_500.getText().toString());
        }

        if (isNotEmpty(new_10)) {
            new_10_val = Integer.parseInt(new_10.getText().toString());
        }
        if (isNotEmpty(new_25)) {
            new_25_val = Integer.parseInt(new_25.getText().toString());
        }
        if (isNotEmpty(new_50)) {
            new_50_val = Integer.parseInt(new_50.getText().toString());
        }
        if (isNotEmpty(new_100)) {
            new_100_val = Integer.parseInt(new_100.getText().toString());
        }
        if (isNotEmpty(new_200)) {
            new_200_val = Integer.parseInt(new_200.getText().toString());
        }
        if (isNotEmpty(new_500)) {
            new_500_val = Integer.parseInt(new_500.getText().toString());
        }

        if (isNotEmpty(pasnger)) {
            pasnger_nu = Double.parseDouble(pasnger.getText().toString());
        } else {
            pasnger_nu = 35;
        }

        if (isNotEmpty(stu_countEdit)) {
            stu_count = Integer.parseInt(stu_countEdit.getText().toString());
        } else {
            stu_count = 15000;
        }

        double reP = pasnger_nu / 100;
        double pp = (100 - pasnger_nu) / 100;

        double totalOld = (old_five_t * 5000) + (old_tow_t * 2000) + (old_one_t * 1000) + (500 * old_five_h);
        double totalNew = (new_10_val * 10 * 100) +
                (new_25_val * 25 * 100) +
                (new_50_val * 50 * 100) +
                (new_100_val * 100 * 100) +
                (new_200_val * 200 * 100) +
                (new_500_val * 500 * 100);

        double resutl = totalOld + totalNew;

        double st_final = resutl * reP;
        double mxm_final = resutl * pp;

        step.setText(String.valueOf(st_final));
        mxm.setText(String.valueOf(mxm_final));
        mainresult.setText(String.valueOf(resutl));
        stu_count_Ui.setText(String.format("%.2f", resutl / stu_count));
    }

    private void Rest_UI() {
        rest_value();

        EditText[] editTexts = {
                old_5000, old_2000, old_1000, old_500,
                new_10, new_25, new_50, new_100, new_200, new_500,
                pasnger, stu_countEdit
        };
        for (EditText editText : editTexts) {
            if (editText != null) {
                editText.setText("");
            }
        }

        step.setText("للمعهد");
        mxm.setText("للاستاذ");
        mainresult.setText("المجموع الكلي");
        stu_count_Ui.setText("0");
    }

    private void save_data() {
    }

    private boolean isNotEmpty(EditText etText) {
        return etText != null && etText.getText().toString().trim().length() > 0;
    }
}