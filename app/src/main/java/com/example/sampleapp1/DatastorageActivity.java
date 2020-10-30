package com.example.sampleapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class DatastorageActivity extends AppCompatActivity {
    public static final String MYFILENAME = "myfilename";
    public static final String KEYTITLE = "keytitle";
    public static final String KEYSUBTITLE = "keysubtitle";
    EditText titleEditText, subtitleEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datastorage);
        titleEditText = findViewById(R.id.editTextTitle);
        subtitleEditText = findViewById(R.id.editTextTextsubtitle);
    }

    @Override
    protected void onPause() {
        super.onPause();
        savePreferences();
    }

    private void savePreferences() {
        //1. get the data from 2 edittexts
        String title = titleEditText.getText().toString();
        String subtitle = subtitleEditText.getText().toString();
        //create a file
        SharedPreferences preferences = getSharedPreferences(MYFILENAME, MODE_PRIVATE);
        //open the file
        SharedPreferences.Editor editor = preferences.edit();
        //write to the file
        editor.putString(KEYTITLE, title);

        editor.putString(KEYSUBTITLE, subtitle);
        //save the file
        editor.commit();
    }


    @Override
    protected void onResume() {
        super.onResume();
        restoreData();
    }

    private void restoreData() {
        //open the file
        SharedPreferences preferences = getSharedPreferences(MYFILENAME, MODE_PRIVATE);
        //read from the file
        String title = preferences.getString(KEYTITLE, "");
        String subtitle = preferences.getString(KEYSUBTITLE, "");
        //restore the data
        titleEditText.setText(title);
        subtitleEditText.setText(subtitle);
    }
}