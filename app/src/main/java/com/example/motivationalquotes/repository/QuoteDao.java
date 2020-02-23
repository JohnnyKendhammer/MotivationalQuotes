package com.example.motivationalquotes.repository;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.motivationalquotes.model.Quote;

import java.util.List;

@Dao
public interface QuoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertQuote(Quote quote);

    @Query("DELETE FROM quote_table")
    void deleteAll();

    @Query("SELECT * from quote_table ORDER BY Random()")
    LiveData<List<Quote>> getAllQuotes();

    @Query("SELECT * from quote_table WHERE author LIKE :authorName")
    LiveData<List<Quote>> getQuoteByAuthor(String authorName);

}
