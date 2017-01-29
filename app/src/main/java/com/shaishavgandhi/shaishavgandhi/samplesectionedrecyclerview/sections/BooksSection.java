package com.shaishavgandhi.shaishavgandhi.samplesectionedrecyclerview.sections;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shaishavgandhi.sectionedrecyclerview.Section;
import com.shaishavgandhi.shaishavgandhi.samplesectionedrecyclerview.R;
import com.shaishavgandhi.shaishavgandhi.samplesectionedrecyclerview.data.models.Book;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by shaishav.gandhi on 11/20/16.
 */

public class BooksSection extends Section<BooksSection.BooksHolder> {


    public List<Book> mData;
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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,mData.get(position).getTitle(), Snackbar.LENGTH_SHORT).show();
            }
        });
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
