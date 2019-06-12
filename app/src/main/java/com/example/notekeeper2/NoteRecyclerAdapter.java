package com.example.notekeeper2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ${paul} on 6/5/2019 at 5:28 PM.
 */
public class NoteRecyclerAdapter extends RecyclerView.Adapter<NoteRecyclerAdapter.viewHolder> {

    List<MyNotes> notesList;

    private LayoutInflater layoutInlater;
    private Context context;


    public NoteRecyclerAdapter( Context context, List<MyNotes> notesList) {
        this.context = context;
        layoutInlater = LayoutInflater.from(context);
        this.notesList = notesList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        View v = layoutInlater.inflate(R.layout.note_view_layout, viewGroup, false);
//        return new viewHolder(v);
        View v = layoutInlater.inflate(R.layout.note_view_layout, viewGroup, false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, int i) {

        MyNotes  notes  = notesList.get(i);
        viewHolder.textTitle.setText(notes.getTitle());
        viewHolder.textSubject.setText(notes.getSubject());
        viewHolder.mCurrentPosition =  i;
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        private final TextView textTitle;
        private final TextView textSubject;
        public int mCurrentPosition;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = (TextView) itemView.findViewById(R.id.NoteTitleTextView);
            textSubject = (TextView) itemView.findViewById(R.id.NoteViewSubject);


            View.OnClickListener onClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent  = new Intent(context.getApplicationContext(), MainActivity.class);
                    intent.putExtra("intVariableName", mCurrentPosition);
                    //intent.putExtra("List Notes", notesList);
                    context.startActivity(intent);
                }
            };
            itemView.setOnClickListener(onClickListener);

        }
    }
}
