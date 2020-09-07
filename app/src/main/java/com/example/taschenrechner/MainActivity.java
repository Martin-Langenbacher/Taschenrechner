package com.example.taschenrechner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView b_c, b_plus_minus, b_prozent, b_geteilt, b_7, b_8, b_9, b_4, b_5, b_6, b_1, b_2, b_3, b_0, b_ml, b_komma, b_mal, b_minus, b_plus, b_gleich;
    String tempString = "";
    String wertEins = "";
    String operator = "";
    //int[][] gameStorage;
    private TextView statusText;
    double wert1;
    double wert2;
    double result;
    boolean error = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // idHeadline ist der Head-Line-String !
        statusText = findViewById(R.id.calculationView);



        b_0 = findViewById(R.id.b_0);
        b_1 = findViewById(R.id.b_1);
        b_2 = findViewById(R.id.b_2);
        b_3 = findViewById(R.id.b_3);
        b_4 = findViewById(R.id.b_4);
        b_5 = findViewById(R.id.b_5);
        b_6 = findViewById(R.id.b_6);
        b_7 = findViewById(R.id.b_7);
        b_8 = findViewById(R.id.b_8);
        b_9 = findViewById(R.id.b_9);

        b_c = findViewById(R.id.b_c);
        b_plus_minus = findViewById(R.id.b_plus_minus);
        b_prozent = findViewById(R.id.b_prozent);
        b_geteilt = findViewById(R.id.b_geteilt);
        b_mal = findViewById(R.id.b_mal);
        b_minus = findViewById(R.id.b_minus);
        b_plus = findViewById(R.id.b_plus);
        b_gleich = findViewById(R.id.b_gleich);
        b_komma = findViewById(R.id.b_komma);
        b_ml = findViewById(R.id.b_ml);

        b_0.setOnClickListener(this);
        b_1.setOnClickListener(this);
        b_2.setOnClickListener(this);
        b_3.setOnClickListener(this);
        b_4.setOnClickListener(this);
        b_5.setOnClickListener(this);
        b_6.setOnClickListener(this);
        b_7.setOnClickListener(this);
        b_8.setOnClickListener(this);
        b_9.setOnClickListener(this);

        b_c.setOnClickListener(this);
        b_plus_minus.setOnClickListener(this);
        b_prozent.setOnClickListener(this);
        b_geteilt.setOnClickListener(this);
        b_mal.setOnClickListener(this);
        b_minus.setOnClickListener(this);
        b_plus.setOnClickListener(this);
        b_gleich.setOnClickListener(this);
        b_komma.setOnClickListener(this);
        b_ml.setOnClickListener(this);

        // gameStorage = new int[3][3];
    }


    @Override
    public void onClick(View v) {
        if(error && v.getId() == R.id.b_c){
            tempString = "";
            error = false;
        } else {
            if (v.getId() == R.id.b_gleich && !error) {
                // Ergebnisberechnung
                switch (operator) {
                    case "+":
                        wert1 = Double.parseDouble(wertEins);
                        wert2 = Double.parseDouble(tempString);
                        result = wert1 + wert2;
                        result = Double.parseDouble(new DecimalFormat("0.00000").format(result));
                        checkSizeOfNumber(result);
                        statusText.setText(tempString);
                        break;
                    case "-":
                        wert1 = Double.parseDouble(wertEins);
                        wert2 = Double.parseDouble(tempString);
                        result = wert1 - wert2;
                        result = Double.parseDouble(new DecimalFormat("0.00000").format(result));
                        tempString = String.valueOf(result);
                        statusText.setText(tempString);
                        break;
                    case "/":
                        wert1 = Double.parseDouble(wertEins);
                        wert2 = Double.parseDouble(tempString);
                        result = wert1 / wert2;
                        result = Double.parseDouble(new DecimalFormat("0.00000").format(result));
                        tempString = String.valueOf(result);
                        statusText.setText(tempString);
                        break;
                    case "*":
                        wert1 = Double.parseDouble(wertEins);
                        wert2 = Double.parseDouble(tempString);
                        result = wert1 * wert2;
                        result = Double.parseDouble(new DecimalFormat("0.00000").format(result));
                        tempString = String.valueOf(result);
                        statusText.setText(tempString);
                        break;
                }





            } else {
                // block of code to be executed if the condition is false
                switch (v.getId()) {
                    case R.id.b_1:
                        tempString = tempString + "1";
                        break;
                    case R.id.b_2:
                        tempString = tempString + "2";
                        break;
                    case R.id.b_3:
                        tempString = tempString + "3";
                        break;
                    case R.id.b_4:
                        tempString = tempString + "4";
                        break;
                    case R.id.b_5:
                        tempString = tempString + "5";
                        break;
                    case R.id.b_6:
                        tempString = tempString + "6";
                        break;
                    case R.id.b_7:
                        tempString = tempString + "7";
                        break;
                    case R.id.b_8:
                        tempString = tempString + "8";
                        break;
                    case R.id.b_9:
                        tempString = tempString + "9";
                        break;
                    case R.id.b_0:
                        if (!tempString.equals("0")) {
                            // do nothing...
                            tempString = tempString + "0";
                        }
                        break;
                    case R.id.b_plus_minus:
                        if (tempString.substring(0, 1).equals("-")) {
                            tempString = tempString.substring(1, tempString.length());
                        } else {
                            //tempString = tempString.substring(0, 1);
                            tempString = "-" + tempString;
                        }
                        break;
                    case R.id.b_geteilt:
                        operator = "/";
                        wertEins = tempString;
                        tempString = "";
                        break;
                    case R.id.b_mal:
                        operator = "*";
                        wertEins = tempString;
                        tempString = "";
                        break;
                    case R.id.b_minus:
                        operator = "-";
                        wertEins = tempString;
                        tempString = "";
                        break;
                    case R.id.b_plus:
                        operator = "+";
                        wertEins = tempString;
                        tempString = "";
                        break;
                    case R.id.b_ml:
                        tempString = "0.00";
                        break;
                    case R.id.b_prozent:
                        wert1 = Double.parseDouble(tempString);
                        result = wert1 / 100;
                        tempString = String.valueOf(result);
                        break;
                    case R.id.b_komma:
                        tempString = "0,0";
                        break;
                    case R.id.b_c:
                        tempString = "0";
                        error = false;
                        break;
                }
            }
            checkLengthOfNumberString(tempString);

        }

        }







    private void checkSizeOfNumber(double resultTemp) {
        if(resultTemp > 999999999.0 || resultTemp < -999999999.0){
            tempString = "e";
            error = true;
        } else {
            tempString = String.valueOf(resultTemp);
        }
    }


    private void checkLengthOfNumberString(String tempStringLength) {
        if (tempString.length() < 10){
            statusText.setText(tempStringLength);
        } else {
            tempString.substring(0, 9).equals(tempStringLength);
        }
    }



}


