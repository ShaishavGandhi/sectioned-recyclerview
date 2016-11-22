package com.example.shaishavgandhi.samplesectionedrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sectionedrecyclerview.Section;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by shaishav.gandhi on 11/20/16.
 */

public class Section2 extends Section<Section2.Section2Holder> {


    List<String> mData;
    Context mContext;

    public Section2(Context context, List<String> data){
        mData = data;
        mContext = context;
    }

    @Override
    public void onBind(Section2Holder holder, final int position) {
        Picasso.with(mContext).load(mData.get(position)).into(holder.mImageView);

        holder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, mData.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getLayout() {
        return R.layout.list_image;
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
    public Section2Holder getViewHolder(View view) {
        return new Section2Holder(view);
    }

    public class Section2Holder extends RecyclerView.ViewHolder {

        ImageView mImageView;

        public Section2Holder(View itemView) {
            super(itemView);

            mImageView = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
