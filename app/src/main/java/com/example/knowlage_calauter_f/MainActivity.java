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

    int five , tow , one ,fiveh = 0;
    EditText fiv_t  , tow_t , one_t , fiv_h_t , pasnger;
    double pasnger_nu;


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

        Button ccl = findViewById(R.id.cala_bt);
        ccl.setOnClickListener(v1 -> Calaut());
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

        double reP = pasnger_nu / 100;
        double pp = (100 - pasnger_nu )/ 100;

        double resutl = (five * 5000) + (tow * 2000) + (one * 1000) + (500 * fiveh) ;

        double st_final = resutl * reP;
        double mxm_final = resutl * pp;


        TextView step = findViewById(R.id.textView);
        TextView mxm = findViewById(R.id.textView7);
        TextView mainresult = findViewById(R.id.titleTextView);

        step.setText(""+st_final);
        mxm.setText(""+ mxm_final);
        mainresult.setText(""+ resutl);

    }
    private boolean isNotEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0) {
            return true;
        }
        return false;
    }
}