package com.example.motivationalquotes.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "quote_table")
public class Quote {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int  key;

    private String author;
    private String quote;
    private int pictureId;

    public Quote(int pictureId, String author, String quote) {
        this.pictureId = pictureId;
        this.author = author;
        this.quote = quote;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }
}
