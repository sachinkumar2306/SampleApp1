package com.example.sampleapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

@SuppressWarnings("ALL")
public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        int c = subTwoNos();
        /*String data = getIntent().getExtras().getString("mykey");
        TextView greetingTextView =  findViewById(R.id.textView);
        greetingTextView.setText(data);*/

        ListView languagesListView = findViewById(R.id.recyclerView2);
        String[] languages = new String[]{"english","hindi","urdu","kannada"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.row_layout_listview,
                R.id.textViewTitle,
                languages);
        languagesListView.setAdapter(adapter);
    }

    private int subTwoNos() {
        return 20 - 30;
    }
}