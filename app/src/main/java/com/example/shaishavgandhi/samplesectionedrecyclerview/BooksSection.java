package com.example.shaishavgandhi.samplesectionedrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sectionedrecyclerview.Section;
import com.example.shaishavgandhi.samplesectionedrecyclerview.models.Book;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by shaishav.gandhi on 11/20/16.
 */

public class BooksSection extends Section<BooksSection.BooksHolder> {


    List<Book> mData;
    Context mContext;

    public BooksSection(Context context, List<Book> data){
        mData = data;
        mContext = context;
    }

    @Override
    public void onBind(BooksHolder holder, final int position) {
        holder.mTitle.setText(mData.get(position).getTitle());
        holder.mAuthor.setText(mData.get(position).getAuthor());
        holder.mDescription.setText(mData.get(position).getDescription());
        Picasso.with(mContext).load(mData.get(position).getPoster()).into(holder.mPoster);
    }

    @Override
    public int getLayout() {
        return R.layout.list_item_books;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public BooksHolder getViewHolder(View view) {
        return new BooksHolder(view);
    }

    public static class BooksHolder extends RecyclerView.ViewHolder {

        TextView mTitle;
        TextView mDescription;
        ImageView mPoster;
        TextView mAuthor;

        public BooksHolder(View itemView) {
            super(itemView);

            mTitle = (TextView) itemView.findViewById(R.id.title);
            mDescription = (TextView) itemView.findViewById(R.id.description);
            mPoster = (ImageView) itemView.findViewById(R.id.poster);
            mAuthor = (TextView) itemView.findViewById(R.id.author);
        }
    }

}