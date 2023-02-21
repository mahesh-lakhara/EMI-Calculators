package com.mmm.emi2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {
    EditText amount,intrest,month;

    TextView txtemi,txtamount,txtintrest;

    Button calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount = findViewById(R.id.amt);
        intrest = findViewById(R.id.intrest);
        month = findViewById(R.id.month);
        calc = findViewById(R.id.calc);
        txtemi = findViewById(R.id.txtemi);
        txtamount = findViewById(R.id.txtamount);
        txtintrest = findViewById(R.id.txtintrest);


       calc.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

            int amt = Integer.parseInt(amount.getText().toString());
            double rest = Double.parseDouble(intrest.getText().toString());
            int mon = Integer.parseInt(month.getText().toString());

            double r = rest/(12*100);
            double cal1 = 1;
               for (int i = 0; i <mon; i++) {
                   cal1 *= (1+r);

               }

               double ans = amt * r * (cal1/(cal1-1));

               txtemi.setText("emi = "+ans);

               double total = ans*mon;
               txtamount.setText("total amount ="+total);

               double iAmt = total-amt;
               txtintrest.setText("intrest amount = "+iAmt);

           }
       });

    }
}