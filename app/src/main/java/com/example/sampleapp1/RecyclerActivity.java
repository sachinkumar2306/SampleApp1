package com.example.sampleapp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    //Declaration
    ArrayList<Note> notesInArrayList;           //note is one box and we will create array of boxes(i.e note)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        notesInArrayList = new ArrayList<>(); //initialization

        createData();
        NotesAdapter adapter = new NotesAdapter(this, notesInArrayList);
        RecyclerView notesRecyclerView = findViewById(R.id.notes_recyclerview);
        notesRecyclerView.setAdapter(adapter);
        notesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void createData() {
        notesInArrayList.add(new Note("title1", "Subtitle1"));
        notesInArrayList.add(new Note("title2", "Subtitle2"));
        notesInArrayList.add(new Note("title3", "Subtitle3"));
        notesInArrayList.add(new Note("title4", "Subtitle4"));
        notesInArrayList.add(new Note("title5", "Subtitle5"));
        notesInArrayList.add(new Note("title6", "Subtitle6"));
    }
}