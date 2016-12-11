package com.example.shaishavgandhi.samplesectionedrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sectionedrecyclerview.Section;
import com.example.shaishavgandhi.samplesectionedrecyclerview.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by shaishav.gandhi on 11/22/16.
 */

public class Section1 extends Section<Section1.Section1Holder> {

    List<Movie> mData;
    Context mContext;

    public Section1(Context context, List<Movie> mData) {
        this.mData = mData;
        this.mContext = context;
    }

    @Override
    public void onBind(Section1Holder holder, final int position) {
        holder.mTitle.setText(mData.get(position).getTitle());
        holder.mDescription.setText(mData.get(position).getDescription());
        Picasso.with(mContext).load(mData.get(position).getPoster()).into(holder.mPoster);
    }

    @Override
    public int getLayout() {
        return R.layout.list_item_movie;
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
    public Section1Holder getViewHolder(View view) {
        return new Section1Holder(view);
    }

    public static class Section1Holder extends RecyclerView.ViewHolder {

        TextView mTitle;
        TextView mDescription;
        ImageView mPoster;

        public Section1Holder(View itemView) {
            super(itemView);

            mTitle = (TextView) itemView.findViewById(R.id.title);
            mDescription = (TextView) itemView.findViewById(R.id.description);
            mPoster = (ImageView) itemView.findViewById(R.id.poster);
        }
    }

    public void replaceData(List<Movie> mData) {
        this.mData = mData;
    }
}
