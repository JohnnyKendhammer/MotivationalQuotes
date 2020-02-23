package com.example.motivationalquotes.repository;

import com.example.motivationalquotes.R;
import com.example.motivationalquotes.model.Quote;

import java.util.ArrayList;
import java.util.List;

public class ListOfQuotes {
    private List<Quote> quotes;

    public ListOfQuotes() {
        quotes = new ArrayList<>();
        createQuoteList();
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

    public void createQuoteList(){
        quotes.add(new Quote(R.drawable.zig_ziglar, "Zig Ziglar", "Rich people have small TVs and big libraries, and poor people have small libraries and big TVs."));
        quotes.add(new Quote(R.drawable.zig_ziglar, "Zig Ziglar", "You don’t have to be great to start, but you have to start to be great."));
        quotes.add(new Quote(R.drawable.zig_ziglar, "Zig Ziglar", "People often say that motivation doesn’t last. Well, neither does bathing – that’s why we recommend it daily."));
        quotes.add(new Quote(R.drawable.zig_ziglar, "Zig Ziglar", "When obstacles arise, you change your direction to reach your goal; you do not change your decision to get there"));
        quotes.add(new Quote(R.drawable.zig_ziglar, "Zig Ziglar", "Among the things you can give and still keep are your word, a smile, and a grateful heart."));
        quotes.add(new Quote(R.drawable.zig_ziglar, "Zig Ziglar", "The chief cause of failure and unhappiness is trading what you want most for what you want right now."));
        quotes.add(new Quote(R.drawable.zig_ziglar, "Zig Ziglar", "If you go out looking for friends, you’re going to find they are very scarce. If you go out to be a friend, you’ll find them everywhere"));
        quotes.add(new Quote(R.drawable.zig_ziglar, "Zig Ziglar", "Lack of direction, not lack of time, is the problem. We all have twenty-four hour days"));
        quotes.add(new Quote(R.drawable.zig_ziglar, "Zig Ziglar", "You were born to win, but to be a winner you must plan to win, prepare to win, and expect to win"));
        quotes.add(new Quote(R.drawable.zig_ziglar, "Zig Ziglar", "If you aim at nothing, you will hit it every time"));
        quotes.add(new Quote(R.drawable.zig_ziglar, "Zig Ziglar", "Attitude, not aptitude, determines altitude"));
        quotes.add(new Quote(R.drawable.zig_ziglar, "Zig Ziglar", "The greatest of all mistakes is to do nothing because you think you can only do a little"));
        quotes.add(new Quote(R.drawable.zig_ziglar, "Zig Ziglar", "Make failure your teacher, not your undertaker"));
        quotes.add(new Quote(R.drawable.zig_ziglar, "Zig Ziglar", "The more you are grateful for what you have the more you will have to be grateful for."));
        quotes.add(new Quote(R.drawable.zig_ziglar, "Zig Ziglar", "Outstanding people have one thing in common: an absolute sense of mission"));
        quotes.add(new Quote(R.drawable.zig_ziglar, "Zig Ziglar", "FEAR has two meanings: ‘Forget Everything And Run’ or ‘Face Everything And Rise.’ The choice is yours"));
        quotes.add(new Quote(R.drawable.zig_ziglar, "Zig Ziglar", "Motivation gets you going and habit gets you there"));
        quotes.add(new Quote(R.drawable.zig_ziglar, "Zig Ziglar", "When you are tough on yourself, life is going to be infinitely easier on you"));


        quotes.add(new Quote(R.drawable.tony_robbins, "Tony Robbins", "The more rejection you get, the better you are, the more you’ve learned, the closer you are to your outcome… If you can handle rejection, you’ll learn to get everything you want"));
        quotes.add(new Quote(R.drawable.tony_robbins, "Tony Robbins", "Your past does not equal your future"));
        quotes.add(new Quote(R.drawable.tony_robbins, "Tony Robbins", "Identify your problems, but give your power and energy to solutions"));
        quotes.add(new Quote(R.drawable.tony_robbins, "Tony Robbins", "Every problem is a gift–without problems we would not grow"));
        quotes.add(new Quote(R.drawable.tony_robbins, "Tony Robbins", "In life you need either inspiration or desperation"));
        quotes.add(new Quote(R.drawable.tony_robbins, "Tony Robbins", "If you can’t, you must. If you must, you can"));
        quotes.add(new Quote(R.drawable.tony_robbins, "Tony Robbins", "When you are grateful fear disappears and abundance appears"));
        quotes.add(new Quote(R.drawable.tony_robbins, "Tony Robbins", "If you do what you’ve always done, you’ll get what you’ve always gotten"));
        quotes.add(new Quote(R.drawable.tony_robbins, "Tony Robbins", "The quality of your life is the quality of your relationships"));
        quotes.add(new Quote(R.drawable.tony_robbins, "Tony Robbins", ""));

    }
}
