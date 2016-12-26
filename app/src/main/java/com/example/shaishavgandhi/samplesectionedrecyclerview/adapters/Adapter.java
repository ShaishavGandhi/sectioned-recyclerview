package com.example.shaishavgandhi.samplesectionedrecyclerview.adapters;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;

import com.example.sectionedrecyclerview.SectionedRecyclerAdapter;
import com.example.shaishavgandhi.samplesectionedrecyclerview.data.models.Book;
import com.example.shaishavgandhi.samplesectionedrecyclerview.data.models.Movie;
import com.example.shaishavgandhi.samplesectionedrecyclerview.sections.BooksHeader;
import com.example.shaishavgandhi.samplesectionedrecyclerview.sections.BooksSection;
import com.example.shaishavgandhi.samplesectionedrecyclerview.sections.MoviesHeader;
import com.example.shaishavgandhi.samplesectionedrecyclerview.sections.MoviesSection;
import com.example.shaishavgandhi.samplesectionedrecyclerview.sections.NativeAd;

import java.util.List;

/**
 * Created by shaishav.gandhi on 11/19/16.
 */

public class Adapter extends SectionedRecyclerAdapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private MoviesSection mMoviesSection;
    private BooksSection mBooksSection;

    public Adapter(Context context, final List<Movie> mMovies, List<Book> mBooks) {
        super(context);

        mContext = context;

        mMoviesSection = new MoviesSection(context, mMovies);
        mBooksSection = new BooksSection(context, mBooks);

        addSection(new MoviesHeader(), mMoviesSection, new BooksHeader(), mBooksSection);

        // Add a ad after 5 seconds
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                NativeAd nativeAd = new NativeAd();
                addSectionAt(4, nativeAd);
                notifyItemInserted(4);
            }
        }, 5000);
    }

    public void addMovie(Movie movie, int position) {
        mMoviesSection.mData.add(position, movie);
        notifySectionItemInserted(mMoviesSection, position);
    }

    public void addMovie(Movie movie) {
        mMoviesSection.mData.add(movie);
        notifySectionItemInserted(mMoviesSection, mMoviesSection.mData.size() - 1);
    }

    public void addBook(Book book, int position) {
        mBooksSection.mData.add(position, book);
        notifySectionItemInserted(mBooksSection, position);
    }

    public void addBook(Book book) {
        mBooksSection.mData.add(book);
        notifySectionItemInserted(mBooksSection, mBooksSection.mData.size() - 1);
    }

    public void removeMovie() {
        int position = mMoviesSection.mData.size() - 1;
        removeMovie(position);
    }

    public void removeMovie(int position) {
        mMoviesSection.mData.remove(position);
        notifySectionItemRemoved(mMoviesSection, position);
    }

    public void removeBook() {
        int position = mBooksSection.mData.size() - 1;
        removeBook(position);
    }

    public void removeBook(int position) {
        mBooksSection.mData.remove(position);
        notifySectionItemRemoved(mBooksSection, position);
    }


}
