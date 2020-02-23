package com.example.motivationalquotes.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.motivationalquotes.model.Quote;

import java.util.List;

public class QuoteRepository {

    private QuoteDao mQuoteDao;
    private LiveData<List<Quote>> quoteList;

    public QuoteRepository(Application application) {
        QuoteRoomDatabase db = QuoteRoomDatabase.getDatabase(application);
        mQuoteDao = db.quoteDao();
        quoteList = mQuoteDao.getAllQuotes();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<Quote>> getAllQuotes() {
        return quoteList;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    public void insert(final Quote quote) {
        QuoteRoomDatabase.databaseWriterExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mQuoteDao.insertQuote(quote);
            }
        });
    }

}
