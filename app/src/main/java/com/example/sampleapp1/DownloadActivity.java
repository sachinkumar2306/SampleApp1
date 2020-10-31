package com.example.sampleapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DownloadActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    ProgressBar mprogressBar;
    EditText mBookInput;
    TextView mTitleText,mAuthorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        Log.i(TAG, "activity created");
        mprogressBar = findViewById(R.id.progressBar);
        mBookInput = findViewById(R.id.bookInput);
        mTitleText = findViewById(R.id.titleText);
        mAuthorText = findViewById(R.id.authorText);
    }


    public void downloadHandler(View view)
    {
        Log.i(TAG,"Button clicked");
        Intent serviceIntent = new Intent(DownloadActivity.this,MusicService.class);

        switch (view.getId()){
            case R.id.buttonstart:
                startService(serviceIntent);
                break;

            case R.id.buttonstop:
                stopService(serviceIntent);
                break;
            case R.id.searchButton:
                searchBooks();
                break;
        }

/*        DownloadTask downloadTask = new DownloadTask(mprogressBar);
        downloadTask.execute("http://lnt.com/imagetobedownloaded");*/
        
    }

    private void searchBooks() {
        String mQueryString = mBookInput.getText().toString();
        new FetchBook().execute(mQueryString);
    }

    private class FetchBook {
        public FetchBook() {
        }

        public void execute(String mQueryString) {

        }
    }
}