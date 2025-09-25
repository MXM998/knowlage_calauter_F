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

    int five , tow , one ,fiveh ,stu_count = 0;
    EditText fiv_t  , tow_t , one_t , fiv_h_t , pasnger ,stu_countEdit;
    double pasnger_nu;

    TextView step , mxm, mainresult, stu_count_Ui;


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

    private  void ins()
    {
        fiv_t = findViewById(R.id.editTextNumber);
        tow_t = findViewById(R.id.editTextNumber2);
        one_t = findViewById(R.id.editTextNumber3);
        fiv_h_t = findViewById(R.id.editTextNumber4);
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
    private  void rest_value()
    {
        five = tow = one = fiveh = 0;
        pasnger_nu = 0;
    }
    @SuppressLint("SetTextI18n")
    private  void Calaut()
    {
        rest_value();
        if (!fiv_t.getText().toString().matches(""))
        {
            five = Integer.parseInt(fiv_t.getText().toString());
        }
        if (isNotEmpty(tow_t))
        {
            tow = Integer.parseInt(tow_t.getText().toString());
        }
        if (!one_t.getText().toString().isEmpty())
        {
            one = Integer.parseInt(one_t.getText().toString());
        }
        if (isNotEmpty(fiv_h_t))
        {
            fiveh = Integer.parseInt(fiv_h_t.getText().toString());
        }
        if (isNotEmpty(pasnger))
        {
            pasnger_nu = Double.parseDouble(pasnger.getText().toString());
        }
        else
        {
            pasnger_nu = 35;
        }
        if(isNotEmpty(stu_countEdit))
        {
            stu_count = Integer.parseInt(stu_countEdit.getText().toString());
        }
        else
        {
            stu_count = 15000;
        }

        double reP = pasnger_nu / 100;
        double pp = (100 - pasnger_nu )/ 100;

        double resutl = (five * 5000) + (tow * 2000) + (one * 1000) + (500 * fiveh) ;

        double st_final = resutl * reP;
        double mxm_final = resutl * pp;


        step.setText(""+st_final);
        mxm.setText(""+ mxm_final);
        mainresult.setText(""+ resutl);
        stu_count_Ui.setText(""+ (resutl / stu_count));


    }
    private void Rest_UI() {
        rest_value();

        EditText[] editTexts = {fiv_t, tow_t, one_t, fiv_h_t, pasnger, stu_countEdit };
        for (EditText editText : editTexts) {
            editText.setText("");
        }

        step.setText("للمعهد");
        mxm.setText("للاستاذ");
        mainresult.setText("المجموع الكلي");
        stu_count_Ui.setText("0");
    }
    private  void save_data()
    {

    }

    private boolean isNotEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0) {
            return true;
        }
        return false;
    }

}


