package com.example.shaishavgandhi.samplesectionedrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.sectionedrecyclerview.Section;
import com.example.shaishavgandhi.samplesectionedrecyclerview.models.Book;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by shaishav.gandhi on 11/20/16.
 */

public class BooksSection extends Section<MoviesSection.Section1Holder> {


    List<Book> mData;
    Context mContext;

    public BooksSection(Context context, List<Book> data){
        mData = data;
        mContext = context;
    }

    @Override
    public void onBind(MoviesSection.Section1Holder holder, final int position) {
        holder.mTitle.setText(mData.get(position).getTitle());
        holder.mDescription.setText(mData.get(position).getAuthor());
        Picasso.with(mContext).load(mData.get(position).getPoster()).into(holder.mPoster);
    }

    @Override
    public int getLayout() {
        return R.layout.list_item_books;
    }

    @Override
    public List<?> getData() {
        return mData;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public MoviesSection.Section1Holder getViewHolder(View view) {
        return new MoviesSection.Section1Holder(view);
    }

}
