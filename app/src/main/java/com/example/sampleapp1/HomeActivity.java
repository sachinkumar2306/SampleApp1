package com.example.sampleapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        int c = subTwoNos(30,20);
        String data = getIntent().getExtras().getString("mykey");
        TextView greetingTextView =  findViewById(R.id.textView);
        greetingTextView.setText(data);
    }

    private int subTwoNos(int i, int i1) {
        return i1 -i;
    }
}