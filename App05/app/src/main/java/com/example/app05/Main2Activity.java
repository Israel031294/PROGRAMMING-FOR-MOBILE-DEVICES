package com.example.app05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView txtvw=findViewById(R.id.textView);
        Intent orgien =getIntent();
        String txt2=orgien.getStringExtra("texto");
        txtvw.setText(txt2);

    }
}
