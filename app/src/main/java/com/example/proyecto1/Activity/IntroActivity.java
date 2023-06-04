package com.example.proyecto1.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.proyecto1.R;

public class IntroActivity extends AppCompatActivity {
  private ConstraintLayout ingBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        ingBtn=findViewById(R.id.ingBtn);
        ingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             startActivity(new Intent(IntroActivity.this, MainActivity.class));
            }
        });
    }
}