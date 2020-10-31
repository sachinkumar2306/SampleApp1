package com.example.sampleapp1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sampleapp1.adapters.NotesAdapter;
import com.example.sampleapp1.model.Note;

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
        Button contextButton = findViewById(R.id.buttoncontext);
        registerForContextMenu(contextButton);
    }

    private void createData() {
        notesInArrayList.add(new Note("title1", "Subtitle1"));
        notesInArrayList.add(new Note("title2", "Subtitle2"));
        notesInArrayList.add(new Note("title3", "Subtitle3"));
        notesInArrayList.add(new Note("title4", "Subtitle4"));
        notesInArrayList.add(new Note("title5", "Subtitle5"));
        notesInArrayList.add(new Note("title6", "Subtitle6"));
    }

    @Override // to show the menu
    public boolean onCreateOptionsMenu(Menu menu) {
            super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
       menuInflater.inflate(R.menu.recycler_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.selectall:

                Toast.makeText(this, "selecting all", Toast.LENGTH_SHORT).show();

                break;
            case R.id.paste:
                Toast.makeText(this, "pasting all", Toast.LENGTH_SHORT).show();

                break;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.list_item_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        super.onContextItemSelected(item);
        if (item.getItemId() == R.id.delete) {
            Toast.makeText(this, "deleting", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}