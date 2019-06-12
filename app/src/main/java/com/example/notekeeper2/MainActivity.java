package com.example.notekeeper2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String NOTE_POSITION = "";
    public List<MyNotes> myListNotes = new ArrayList<>();
    EditText txtTitle;
    EditText txtSubject;
    EditText txtContent;

    MyNotes localNote;
    int position; //= Integer.parseInt(NOTE_POSITION);
    private int intValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtTitle = (EditText) findViewById(R.id.NoteTitleDisplay);
        txtSubject = (EditText) findViewById(R.id.NoteSubjectTextView);
        txtContent = (EditText) findViewById(R.id.NoteContectTextView);

        DataManager dm =  new DataManager();
        dm.IntializeList();
//        position = Integer.parseInt(String.valueOf(getIntent().getExtras()));

        Intent mIntent = getIntent();
        intValue = mIntent.getIntExtra("intVariableName", 0);

        localNote = dm.getData(intValue);


        txtTitle.setText(localNote.getTitle());
        txtSubject.setText(localNote.getSubject());
        txtContent.setText(localNote.getContent());

    }

    @Override
    protected void onPause() {

        String newTitle = txtTitle.getText().toString();
        String newSubject = txtSubject.getText().toString();
        String newContent = txtContent.getText().toString();

        Intent i = new Intent(MainActivity.this, NoteListActivity.class);
        i.putExtra("title", newTitle);
        i.putExtra("subject", newSubject);
        i.putExtra("content", newContent);
        i.putExtra("noteId", intValue);

        startActivity(i);
        super.onPause();
        //super.onDestroy();
    }
}
