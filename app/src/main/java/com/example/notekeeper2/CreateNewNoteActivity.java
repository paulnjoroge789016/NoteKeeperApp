package com.example.notekeeper2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CreateNewNoteActivity extends AppCompatActivity {
    MyNotes newNote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_note);

        newNote.setTitle();
       // NoteListActivity.notesList.add();
    }
}
