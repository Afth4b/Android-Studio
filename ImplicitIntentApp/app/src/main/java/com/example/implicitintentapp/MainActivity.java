package com.example.implicitintentapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button openWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openWebsite = findViewById(R.id.b1);

        openWebsite.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);

            intent.setData(
                    Uri.parse("https://www.cet.ac.in")
            );

            startActivity(intent);
        });
    }
}