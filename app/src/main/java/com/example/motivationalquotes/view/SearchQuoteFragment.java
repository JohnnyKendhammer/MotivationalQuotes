package com.example.motivationalquotes.view;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.motivationalquotes.R;
import com.example.motivationalquotes.adapter.QuoteListAdapter;
import com.example.motivationalquotes.model.Quote;
import com.example.motivationalquotes.viewmodel.QuoteViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchQuoteFragment extends Fragment {
    private QuoteViewModel quoteViewModel;
    private RecyclerView mRecyclerView;
    private QuoteListAdapter mQuoteListAdapter;
    private AppCompatButton btnSearch;
    private AppCompatEditText etQuery;
    public static final int NEW_QUOTE_ACTIVITY_REQUEST_CODE = 1;

    public SearchQuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_quote, container, false);
        btnSearch = view.findViewById(R.id.btnSearch);
        mRecyclerView = view.findViewById(R.id.rvSearchResults);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(manager);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        quoteViewModel = new ViewModelProvider(this).get(QuoteViewModel.class);
        setupObserver();

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*etQuery = v.findViewById(R.id.etQuery);
                String word = etQuery.getText().toString();*/
                quoteViewModel.getAllQuotes();
                hideSoftKeyboard(v);
            }
        });
    }

    private void setupObserver() {
        quoteViewModel.getAllQuotes().observe(getViewLifecycleOwner(), new Observer<List<Quote>>() {
            @Override
            public void onChanged(List<Quote> quotes) {
                mQuoteListAdapter = new QuoteListAdapter(getContext(), quotes);
                mRecyclerView.setAdapter(mQuoteListAdapter);
            }
        });
    }

    public void hideSoftKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
