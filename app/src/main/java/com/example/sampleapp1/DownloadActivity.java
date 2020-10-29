package com.example.sampleapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

public class DownloadActivity extends AppCompatActivity {
    public static String TAG = MainActivity.class.getSimpleName();
    ProgressBar mprogressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        Log.i(TAG, "activity created");
        mprogressBar = findViewById(R.id.progressBar);
    }


    public void downloadHandler(View view)
    {
        Log.i(TAG,"Button clicked");


        DownloadTask downloadTask = new DownloadTask(mprogressBar);
        downloadTask.execute("http://lnt.com/imagetobedownloaded");
    }
}