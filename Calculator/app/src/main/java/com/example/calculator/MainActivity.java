package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText display;

    double firstNumber;
    String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        int[] buttons = {
                R.id.b0,
                R.id.b1,
                R.id.b2,
                R.id.b3,
                R.id.b4,
                R.id.b5,
                R.id.b6,
                R.id.b7,
                R.id.b8,
                R.id.b9,
                R.id.bdot,
                R.id.bplus,
                R.id.bminus,
                R.id.bmultiply,
                R.id.bdivide,
                R.id.bequal,
                R.id.bclear
        };

        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Button button = (Button) view;
                String value = button.getText().toString();

                // Clear
                if (value.equals("C")) {

                    display.setText("");
                }

                // Operators
                else if (value.equals("+") ||
                        value.equals("-") ||
                        value.equals("*") ||
                        value.equals("/")) {

                    firstNumber = Double.parseDouble(
                            display.getText().toString()
                    );

                    operator = value;

                    display.setText("");
                }

                // Equal
                else if (value.equals("=")) {

                    double secondNumber = Double.parseDouble(
                            display.getText().toString()
                    );

                    double result = 0;

                    if (operator.equals("+")) {
                        result = firstNumber + secondNumber;
                    }
                    else if (operator.equals("-")) {
                        result = firstNumber - secondNumber;
                    }
                    else if (operator.equals("*")) {
                        result = firstNumber * secondNumber;
                    }
                    else if (operator.equals("/")) {
                        result = firstNumber / secondNumber;
                    }

                    display.setText(String.valueOf(result));
                }

                // Numbers and decimal point
                else {

                    display.setText(
                            display.getText().toString() + value
                    );
                }
            }
        };

        // Set listener for all buttons
        for (int id : buttons) {

            findViewById(id).setOnClickListener(listener);
        }
    }
}