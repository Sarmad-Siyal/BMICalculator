package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText  edtWait, edtHeightFt, edtHeightInch;
        Button btnCalculate;
        TextView txt;
        LinearLayout llMain;

        edtWait=findViewById(R.id.edtWait);
        edtHeightFt=findViewById(R.id.edtHeightFt);
        edtHeightInch=findViewById(R.id.edtHeightInch);
        btnCalculate=findViewById(R.id.btmCalculate);
        txt=findViewById(R.id.btmText);
        llMain=findViewById(R.id.llMain);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                int wt= Integer.parseInt(edtWait.getText().toString());
                int ft= Integer.parseInt(edtHeightFt.getText().toString());
                int inch= Integer.parseInt(edtHeightInch.getText().toString());
                int totalInch=ft*12+inch;
                double cm=totalInch*2.53;
                double mt=cm/100;
                double bmi=wt/(mt*mt);
                if(bmi>25){
                    txt.setText(" You are over waited");
                    llMain.setBackgroundColor(getResources().getColor(R.color.Overwt));
                }
                else if(bmi<18){
                    txt.setText(" you are under wait");
                    llMain.setBackgroundColor(getResources().getColor(R.color.underwt));
                }
                else{
                    txt.setText(" You are Healthy");
                    llMain.setBackgroundColor(getResources().getColor(R.color.Healthy));
                }
            }
        });
    }
}
