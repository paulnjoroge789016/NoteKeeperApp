package com.example.notekeeper2;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.*;

/**
 * Created by ${paul} on 6/5/2019 at 6:16 PM.
 */
public class DataManager  {
    public MyNotes temp;
    public MyNotes notes;
    public int position;
    public List<MyNotes> myNotes = new ArrayList<>();
    String title = "title 1";
    String subject = "subject 1" ;
    String content = "content 1";


    public MyNotes getData(int position) {

        this.position  = position;
        temp = myNotes.get(position);
        return temp;
    }

    public void IntializeList() {

        notes = new MyNotes("Me one", "subject 1", "content 1");
        myNotes.add(notes);
        notes = new MyNotes("Title 2", "subject 2", "content 2" );
        myNotes.add(notes);
        notes = new MyNotes("Title 3", "subject 3", "content 3");
        myNotes.add(notes);
    }

    public List<MyNotes> getMyNotes()
    {
        return myNotes;
    }
}
