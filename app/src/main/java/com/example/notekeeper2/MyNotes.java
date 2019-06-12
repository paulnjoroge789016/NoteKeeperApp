package com.example.notekeeper2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ${paul} on 6/5/2019 at 4:12 PM.
 */
public class MyNotes implements Parcelable {

    String Title;
    String Subject;
    String Content;

    public MyNotes(String title, String subject, String content) {
        this.Title = title;
        this.Subject = subject;
        this.Content = content;
    }

    protected MyNotes(Parcel in) {
        Title = in.readString();
        Subject = in.readString();
        Content = in.readString();
    }

    public static final Creator<MyNotes> CREATOR = new Creator<MyNotes>() {
        @Override
        public MyNotes createFromParcel(Parcel in) {
            return new MyNotes(in);
        }

        @Override
        public MyNotes[] newArray(int size) {
            return new MyNotes[size];
        }
    };

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(Title);
        dest.writeString(Subject);
        dest.writeString(Content);
    }
}
