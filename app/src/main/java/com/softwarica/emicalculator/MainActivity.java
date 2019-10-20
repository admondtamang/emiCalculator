package com.softwarica.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button btnCalculate;
    EditText etPrincipal,etTime,etRate;
    TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize view
        etPrincipal=findViewById(R.id.etPrincipal);
        etTime =findViewById(R.id.etTime);
        etRate=findViewById(R.id.etRate);
        tvOutput=findViewById(R.id.tvOutput);
        btnCalculate=findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Validation
                if(etPrincipal.getText().toString().matches("")){
                    etPrincipal.setError("Enter Principal");
                    return;
                }
                if(etRate.getText().toString().matches("")){
                    etRate.setError("Enter Rate");
                    return;
                }
                if(etTime.getText().toString().matches("")){
                    etTime.setError("Enter Time");
                    return;
                }

                Double p,r,n,result;
                p=Double.parseDouble(etPrincipal.getText().toString());
                r=Double.parseDouble(etRate.getText().toString());
                n=Double.parseDouble(etTime.getText().toString());

                r = r / (12 * 100);

                Emi emi=new Emi(p,r,n);
                result=emi.getEmi();
                tvOutput.setText("Monthly Installment:"+new DecimalFormat("##.##").format(result));

            }
        });

    }
}
