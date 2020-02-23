package com.example.motivationalquotes.repository;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.motivationalquotes.model.Quote;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Quote.class}, version = 1, exportSchema = false)
public abstract class QuoteRoomDatabase extends RoomDatabase {

    public abstract QuoteDao quoteDao();

    private static volatile QuoteRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriterExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private static QuoteDao dao;

    static QuoteRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Quote.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            QuoteRoomDatabase.class, "quote_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriterExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    dao = INSTANCE.quoteDao();
                    dao.deleteAll();
                    getQuotes();
                }
            });
        }
    };

    private static void getQuotes() {
        ListOfQuotes listOfQuotes = new ListOfQuotes();
        List<Quote> quotes = listOfQuotes.getQuotes();
        for (Quote quote : quotes) {
            dao.insertQuote(quote);
        }
    }

}
