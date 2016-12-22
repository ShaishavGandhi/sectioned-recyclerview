package com.example.shaishavgandhi.samplesectionedrecyclerview;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;

import com.example.sectionedrecyclerview.SectionedRecyclerAdapter;
import com.example.shaishavgandhi.samplesectionedrecyclerview.models.Book;
import com.example.shaishavgandhi.samplesectionedrecyclerview.models.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shaishav.gandhi on 11/19/16.
 */

public class Adapter extends SectionedRecyclerAdapter<RecyclerView.ViewHolder> {

    private Context mContext;

    public Adapter(Context context, final List<Movie> mData, List<Book> mData2) {
        super(context);

        final MoviesSection moviesSection = new MoviesSection(context, mData);
        List<String> mHeader = new ArrayList<>();
        mHeader.add("misc");
        HeaderSection headerSection = new HeaderSection(mHeader);

        final BooksSection booksSection = new BooksSection(context, mData2);
        addSection(headerSection);
        addSection(moviesSection);
        addSection(new BooksHeader());
        addSection(booksSection);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                NativeAd nativeAd = new NativeAd();
                addSectionAt(4, nativeAd);
                notifySectionItemInserted(4);
            }
        }, 5000);
    }

}
