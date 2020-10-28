package com.example.sampleapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        int c = subTwoNos(30,20);
        /*String data = getIntent().getExtras().getString("mykey");
        TextView greetingTextView =  findViewById(R.id.textView);
        greetingTextView.setText(data);*/

        ListView languagesListView = findViewById(R.id.recyclerView2);
        String[] languages = new String[]{"english","hindi","urdu","kannada"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.row_layout_listview,
                R.id.textViewTitle,
                languages);
        languagesListView.setAdapter(adapter);
    }

    private int subTwoNos(int i, int i1) {
        return i1 -i;
    }
}