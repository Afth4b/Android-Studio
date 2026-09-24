package com.example.radiocheckapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.radiocheckapp.R;

public class MainActivity extends AppCompatActivity {

    Button b1;
    RadioGroup rg;
    RadioButton r1, r2;
    CheckBox e, m, h;
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.submit);

        r1 = (RadioButton) findViewById(R.id.male);
        r2 = (RadioButton) findViewById(R.id.female);

        e = (CheckBox) findViewById(R.id.e);
        m = (CheckBox) findViewById(R.id.m);
        h = (CheckBox) findViewById(R.id.h);

        t = (TextView) findViewById(R.id.tv);

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                t.setText("Languages Known: ");

                if (e.isChecked()) {
                    t.setText(t.getText().toString() + " " + e.getText());
                }

                if (m.isChecked()) {
                    t.setText(t.getText().toString() + " " + m.getText());
                }

                if (h.isChecked()) {
                    t.setText(t.getText().toString() + " " + h.getText());
                }
            }
        });

        rg = (RadioGroup) findViewById(R.id.rg);

        rg.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(
                            RadioGroup group,
                            int checkedId) {

                        if (checkedId == R.id.female) {

                            Toast.makeText(
                                    getApplicationContext(),
                                    r2.getText().toString(),
                                    Toast.LENGTH_SHORT
                            ).show();

                        } else {

                            Toast.makeText(
                                    getApplicationContext(),
                                    r1.getText().toString(),
                                    Toast.LENGTH_SHORT
                            ).show();
                        }
                    }
                }
        );
    }
}