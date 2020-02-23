package com.example.motivationalquotes.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.motivationalquotes.R;
import com.example.motivationalquotes.model.Quote;

import java.util.List;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

public class QuoteListAdapter extends RecyclerView.Adapter<QuoteListAdapter.QuoteListViewHolder> {

    private final LayoutInflater mLayoutInflater;
    private List<Quote> mQuotes;
    private Context mContext;

    public QuoteListAdapter(Context context, List<Quote> quotes) {
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.mQuotes = quotes;
    }

    @NonNull
    @Override
    public QuoteListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.fragment_quote, parent, false);
        return new QuoteListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteListViewHolder holder, int position) {
        if (mQuotes != null) {
            final Quote currentQuote = mQuotes.get(position);
            try {

                setViews(currentQuote, holder.ivPic, holder.quoteContainer, holder.tvAuthor, holder.tvQuote);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    @Override
    public int getItemCount() {
        if (mQuotes != null) {
            return mQuotes.size();
        } else {
            return 0;
        }
    }

    class QuoteListViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView ivPic;
        private AppCompatTextView tvAuthor;
        private AppCompatTextView tvQuote;
        private ConstraintLayout quoteContainer;

        public QuoteListViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPic = itemView.findViewById(R.id.ivPic);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvQuote = itemView.findViewById(R.id.tvQuote);
            quoteContainer = itemView.findViewById(R.id.cvQuoteContainer);
        }
    }

    public void setQuotes(List<Quote> quotes) {
        mQuotes = quotes;
        notifyDataSetChanged();
    }

    public void setViews(Quote currentQuote, CircleImageView ivPic, ConstraintLayout quoteContainer, AppCompatTextView tvAuthor, AppCompatTextView tvQuote) {
        ivPic.setImageResource(currentQuote.getPictureId());
        tvAuthor.setText(currentQuote.getAuthor());
        tvQuote.setText(currentQuote.getQuote());
        Random r = new Random();
        int x = r.nextInt(6) + 1;
        switch (x) {
            case 1:
                quoteContainer.setBackground(ContextCompat.getDrawable(mContext, R.drawable.snowman));
                tvAuthor.setTextColor(Color.BLACK);
                tvQuote.setTextColor(Color.BLACK);
                break;
            case 2:
                quoteContainer.setBackground(ContextCompat.getDrawable(mContext, R.drawable.desert_background));
                tvAuthor.setTextColor(Color.BLACK);
                tvQuote.setTextColor(Color.BLACK);
                break;
            case 3:
                quoteContainer.setBackground(ContextCompat.getDrawable(mContext, R.drawable.forest_background));
                tvAuthor.setTextColor(Color.WHITE);
                tvQuote.setTextColor(Color.WHITE);
                break;
            case 4:
                quoteContainer.setBackground(ContextCompat.getDrawable(mContext, R.drawable.ocean_underwater));
                tvAuthor.setTextColor(Color.BLACK);
                tvQuote.setTextColor(Color.BLACK);
                break;
            case 5:
                quoteContainer.setBackground(ContextCompat.getDrawable(mContext, R.drawable.space2));
                tvAuthor.setTextColor(Color.WHITE);
                tvQuote.setTextColor(Color.WHITE);
                break;
            case 6:
                quoteContainer.setBackground(ContextCompat.getDrawable(mContext, R.drawable.deep_space));
                tvAuthor.setTextColor(Color.WHITE);
                tvQuote.setTextColor(Color.WHITE);
                break;
        }
    }
}
