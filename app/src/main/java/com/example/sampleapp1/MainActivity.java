package com.example.sampleapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameEditText;  //declaration
    public  static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "Created");
        nameEditText =findViewById(R.id.editTextTextPersonName6);   //init
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Start Activity started");
    }

    /**
     * Dispatch onPause() to fragments.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Activity Paused");
    }

    /**
     * Dispatch onResume() to fragments.  Note that for better inter-operation
     * with older versions of the platform, at the point of this call the
     * fragments attached to the activity are <em>not</em> resumed.
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Activity Resumed");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, " Activity Stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Activity is Destroyed");
    }

    public void clickHandler(View view) {
        String name = nameEditText.getText().toString();   //using
        Log.v(TAG,"Button Clicked");
        switch (view.getId())
        {
            case R.id.button2:
                Log.w(TAG, "Logging in");
                Toast.makeText(this, "Welcome to android " + name, Toast.LENGTH_SHORT).show();
                Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
                homeIntent.putExtra("mykey",  name);
                startActivity(homeIntent);
                break;
            case R.id.button3:
                Log.e(TAG, "Cancelling");
                Toast.makeText(this, "please fill the details properly " + name, Toast.LENGTH_SHORT).show();
                Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:83389058"));
                startActivity(dialIntent);
                break;
        }
    }
}