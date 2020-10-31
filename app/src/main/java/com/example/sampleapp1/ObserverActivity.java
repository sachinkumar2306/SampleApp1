package com.example.sampleapp1;

import android.os.Bundle;

import com.example.sampleapp1.observer.MyPostOffice;
import com.example.sampleapp1.observer.MyTopicSubscriber;
import com.example.sampleapp1.observer.Observer;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;

public class ObserverActivity extends AppCompatActivity {
    EditText msgEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        msgEditText = findViewById(R.id.editTextMessage);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            observerTest();
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        });
    }

    private void observerTest() {
        //create subject
        MyPostOffice postOffice = new MyPostOffice();

        //create observers
        Observer person1 = new MyTopicSubscriber("parthiban");
        Observer person2 = new MyTopicSubscriber("sohel");
        Observer person3 = new MyTopicSubscriber("shikar");

        //register observers to the subject
        postOffice.register(person1);
        postOffice.register(person2);
        postOffice.register(person3);

        //attach observer to subject
        person1.setSubject(postOffice);
        person2.setSubject(postOffice);
        person3.setSubject(postOffice);

        //check if any update is available
        person1.update();

        //now send message to subject
        postOffice.postMessage(msgEditText.getText().toString());
    }
}