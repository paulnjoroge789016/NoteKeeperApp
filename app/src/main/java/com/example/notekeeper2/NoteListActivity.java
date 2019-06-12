package com.example.notekeeper2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import static android.os.Build.VERSION_CODES.M;

public class NoteListActivity extends AppCompatActivity {

    public static List<MyNotes> notesList  =  new ArrayList<MyNotes>();
    private RecyclerView recyclerView;
    private NoteRecyclerAdapter adapter;
    private LinearLayoutManager lm;

    MyNotes noteTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_note_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DataManager dm =  new DataManager();
        dm.IntializeList();

        notesList =dm.getMyNotes();

        displayItems();
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(NoteListActivity.this , CreateNewNoteActivity.class));
            }
        });
        super.onCreate(savedInstanceState);
    }


    private void displayItems() {
        recyclerView = (RecyclerView) findViewById(R.id.NotesRecyclerView);

        lm = new LinearLayoutManager(this);
        adapter = new NoteRecyclerAdapter( this,notesList);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        adapter.notifyDataSetChanged();
        Intent intent = getIntent();
        if(intent.getExtras() == null){
            recyclerView.setLayoutManager(lm);
            recyclerView.setAdapter(adapter);}
        else {
            String Title = intent.getStringExtra("title");
            String Subject = intent.getStringExtra("subject");
            String content = intent.getStringExtra("content");
            int myNoteIt = intent.getIntExtra("noteId", 0);
            MyNotes smallNote = notesList.get(myNoteIt);

            smallNote.setTitle(Title);
            smallNote.setSubject(Subject);
            smallNote.setContent(content);

            adapter.notifyDataSetChanged();
            recyclerView.setAdapter(adapter);
        }
        super.onResume();
    }

    @Override
    protected void onPause() {

        super.onPause();
    }

}
