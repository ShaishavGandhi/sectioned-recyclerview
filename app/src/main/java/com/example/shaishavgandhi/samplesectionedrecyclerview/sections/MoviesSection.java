package com.example.shaishavgandhi.samplesectionedrecyclerview.sections;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sectionedrecyclerview.Section;
import com.example.shaishavgandhi.samplesectionedrecyclerview.R;
import com.example.shaishavgandhi.samplesectionedrecyclerview.data.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by shaishav.gandhi on 11/22/16.
 */

public class MoviesSection extends Section<MoviesSection.MoviesHolder> {

    public List<Movie> mData;
    Context mContext;

    public MoviesSection(Context context, List<Movie> mData) {
        this.mData = mData;
        this.mContext = context;
    }

    @Override
    public void onBind(MoviesHolder holder, final int position) {
        holder.mTitle.setText(mData.get(position).getTitle());
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
        return R.layout.list_item_movie;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public MoviesHolder getViewHolder(View view) {
        return new MoviesHolder(view);
    }

    public static class MoviesHolder extends RecyclerView.ViewHolder {

        TextView mTitle;
        TextView mDescription;
        ImageView mPoster;

        public MoviesHolder(View itemView) {
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
