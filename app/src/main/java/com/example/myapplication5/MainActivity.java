package com.example.myapplication5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
     Spinner spinner;
     EditText editText;
     Button btn;
     Double mnt;
     List<String> items;
     String montant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner =findViewById(R.id.spinner);
        items=new ArrayList<>();
        items.add("MAD");
        items.add("Euro");
        items.add("Dollar");
        spinner.setAdapter(new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,items));
        btn=findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
                String text = mySpinner.getSelectedItem().toString();
                TextView txt = findViewById(R.id.textView);
                TextView txt2 = findViewById(R.id.textView1);
                montant= ((EditText)findViewById(R.id.montant)).getText().toString();
                mnt=Double.valueOf(montant);
                txt.setText(montant);
                DecimalFormat df = new DecimalFormat("0.00");

                if(text=="MAD"){
                    double e=mnt*0.091;

                    txt.setText(String.valueOf(df.format(e))+" €");
                    double e1=mnt*0.097;
                    txt2.setText(String.valueOf(df.format(e1))+" $");
                     }
                else if(text=="Euro"){
                    double e=mnt*11.01;
                    txt.setText(String.valueOf(df.format(e))+" MAD");
                    double e1=mnt*1.06;
                    txt2.setText(String.valueOf(df.format(e1))+" $");}
                else {
                    double e=mnt*10.34;
                    txt.setText(String.valueOf(df.format(e))+" MAD");
                    double e1=mnt*0.94;
                    txt2.setText(String.valueOf(df.format(e1))+" €");}
                }
        });
    }
}