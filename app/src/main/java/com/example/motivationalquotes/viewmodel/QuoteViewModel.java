package com.example.motivationalquotes.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.motivationalquotes.model.Quote;
import com.example.motivationalquotes.repository.QuoteRepository;

import java.util.List;

public class QuoteViewModel extends AndroidViewModel {
    private QuoteRepository mQuoteRepository;
    private LiveData<List<Quote>> allQuotes;

    public QuoteViewModel(@NonNull Application application) {
        super(application);
        mQuoteRepository = new QuoteRepository(application);
        allQuotes = mQuoteRepository.getAllQuotes();
    }

    public LiveData<List<Quote>> getAllQuotes(){
        return  allQuotes;
    }

    public void insert(Quote quote){
        mQuoteRepository.insert(quote);
    }
}
