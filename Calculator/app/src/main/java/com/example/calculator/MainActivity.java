package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText t1;
    Button bac;

    String firstNumber = "";
    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = findViewById(R.id.t1);
        bac = findViewById(R.id.bac);

        int b[] = new int[17];

        for (int i = 0; i <= 16; i++) {

            String s = "b" + i;

            int rid = getResources().getIdentifier(
                    s,
                    "id",
                    getPackageName()
            );

            b[i] = rid;
        }

        for (int id : b) {

            Button button = findViewById(id);

            if (button != null) {

                button.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        handleButtonClick(view.getId());
                    }
                });
            }
        }

        bac.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                t1.setText("");
                firstNumber = "";
                operator = "";
            }
        });
    }

    private void handleButtonClick(int id) {

        String txt = t1.getText().toString();

        // Equal
        if (id == R.id.b16) {

            if (!firstNumber.isEmpty()
                    && !operator.isEmpty()
                    && !txt.isEmpty()) {

                double num1 = Double.parseDouble(firstNumber);
                double num2 = Double.parseDouble(txt);

                double result = 0;

                switch (operator) {

                    case "+":
                        result = num1 + num2;
                        break;

                    case "-":
                        result = num1 - num2;
                        break;

                    case "x":
                        result = num1 * num2;
                        break;

                    case "/":

                        if (num2 != 0) {
                            result = num1 / num2;
                        }

                        break;
                }

                t1.setText(String.valueOf(result));

                firstNumber = "";
                operator = "";
            }
        }

        // Decimal
        else if (id == R.id.b10) {

            if (!txt.contains(".")) {

                t1.setText(
                        txt + "."
                );
            }
        }

        // Operators
        else if (id == R.id.b12
                || id == R.id.b13
                || id == R.id.b14
                || id == R.id.b15) {

            if (!txt.isEmpty()) {

                firstNumber = txt;

                operator = ((Button) findViewById(id))
                        .getText()
                        .toString();

                t1.setText("");
            }
        }

        // Backspace
        else if (id == R.id.b11) {

            if (!txt.isEmpty()) {

                t1.setText(
                        txt.substring(0, txt.length() - 1)
                );
            }
        }

        // Numbers
        else {

            t1.setText(
                    txt + ((Button) findViewById(id))
                            .getText()
            );
        }
    }
}