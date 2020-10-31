package com.example.sampleapp1;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

@SuppressWarnings("ALL")
public class DownloadTask extends AsyncTask<String,Integer,Void> {
    public static final String TAG = DownloadTask.class.getSimpleName();
final ProgressBar progressBar;
    @SuppressWarnings("deprecation")
    public DownloadTask(ProgressBar mprogressBar) {
        progressBar = mprogressBar;
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressBar.setVisibility(View.VISIBLE);
    }


    @SuppressWarnings("deprecation")
    @Override
    protected Void doInBackground(String... downloadUrl) {
        Log.i(TAG,"doInBackground --downloadUrl= "+downloadUrl[0]);
        publishProgress(50);
        try {
            for (int i=1; i<21;i++){
                publishProgress(i*5);

                Thread.sleep(100);
            }

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Log.i(TAG,"onProgressUpdate --progress= "+values[0]);

        progressBar.setProgress(values[0]);
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        progressBar.setVisibility(View.INVISIBLE);
    }
}