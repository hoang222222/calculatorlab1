package com.example.calculatorlab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //String arr[] = {"Phép tính","+","-","x","/"};
    String result;
    String select;
    Spinner sp_cal;
    Button btn_cal;
    EditText et_01;
    EditText et_02;
    TextView tv_res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_01 = findViewById(R.id.et_01);
        et_02 = findViewById(R.id.et_02);
        tv_res = findViewById(R.id.tv_res);
        btn_cal = findViewById(R.id.btn_cal);
        sp_cal = findViewById(R.id.sp_cal);

        ArrayList<String> arr = new ArrayList<String>();
        arr.add("Chon phep tinh");
        arr.add("+");
        arr.add("-");
        arr.add("x");
        arr.add("/");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item,arr);
        sp_cal.setAdapter(adapter);


        sp_cal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                select = arr.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "Chọn phép tính", Toast.LENGTH_LONG).show();
            }
        });

        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double num1 = Double.parseDouble(et_01.getText().toString());
                    double num2 = Double.parseDouble(et_02.getText().toString());
                    if(select.equals("+")){
                        result = " "+(num1+num2);
                        tv_res.setText(result);
                    } else if (select.equals("-")){
                        result = " "+(num1-num2);
                        tv_res.setText(result);
                    } else if (select.equals("x")){
                        result = " "+(num1*num2);
                        tv_res.setText(result);
                    } else if (select.equals("/")){
                        result = " "+(num1/num2);
                        tv_res.setText(result);
                    } else {
                        Toast.makeText(MainActivity.this, "Chưa chọn phép tính", Toast.LENGTH_LONG).show();
                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Wrong data", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}