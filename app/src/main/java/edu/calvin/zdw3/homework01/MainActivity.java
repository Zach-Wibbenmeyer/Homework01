package edu.calvin.zdw3.homework01;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /* CS 262 - Homework 01: Build a simple calculator app
     * Professor: Keith Vanderlinden
     * Author: Zach Wibbenmeyer
     * Date: September 30, 2016
     */

    // set up private variables
    private Button addButton, subtractButton, multiplyButton, divideButton;
    private EditText numberOneEditText, numberTwoEditText;
    private TextView resultsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize widgets
        addButton = (Button) findViewById(R.id.addButton);
        subtractButton = (Button) findViewById(R.id.subtractButton);
        multiplyButton = (Button) findViewById(R.id.multiplyButton);
        divideButton = (Button) findViewById(R.id.divideButton);
        numberOneEditText = (EditText) findViewById(R.id.numberOneEditText);
        numberTwoEditText = (EditText) findViewById(R.id.numberTwoEditText);
        resultsTextView = (TextView) findViewById(R.id.resultsTextView);

        // set onclicklisteners
        addButton.setOnClickListener(this);
        subtractButton.setOnClickListener(this);
        multiplyButton.setOnClickListener(this);
        divideButton.setOnClickListener(this);
    }

    /* onClick() - performs the basic math for the calculator
     * @param: v (type -> View)
     * @return: resultsTextView (type -> int)
     * Precondition: Cannot divide by zero or enter negative numbers
     */
    @Override
    public void onClick(View v) {
        // set up the first and second numbers
        String firstNumber = numberOneEditText.getText().toString();
        String secondNumber = numberTwoEditText.getText().toString();
        // switch on Id
        switch(v.getId()) {
            case R.id.addButton:
                int addition = Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber);
                resultsTextView.setText(String.valueOf(addition));
                break;
            case R.id.subtractButton:
                int subtraction = Integer.parseInt(firstNumber) - Integer.parseInt(secondNumber);
                resultsTextView.setText(String.valueOf(subtraction));
                break;
            case R.id.multiplyButton:
                int multiplication = Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber);
                resultsTextView.setText(String.valueOf(multiplication));
                break;
            case R.id.divideButton:
                // implement a try catch for division so program won't crash
                try {
                    int division = Integer.parseInt(firstNumber) / Integer.parseInt(secondNumber);
                    resultsTextView.setText(String.valueOf(division));
                } catch (Exception e) {
                        resultsTextView.setText("Cannot divide by this number...");
                }
                break;
        }
    }
}
