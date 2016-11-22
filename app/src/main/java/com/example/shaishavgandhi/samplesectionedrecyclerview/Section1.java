package com.example.shaishavgandhi.samplesectionedrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sectionedrecyclerview.Section;

import java.util.List;

/**
 * Created by shaishav.gandhi on 11/22/16.
 */

public class Section1 extends Section<Section1.Section1Holder> {

    List<String> mData;
    Context mContext;

    public Section1(Context context, List<String> mData) {
        this.mData = mData;
        this.mContext = context;
    }

    @Override
    public void onBind(Section1Holder holder, final int position) {
        holder.mTextView.setText(mData.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, mData.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getLayout() {
        return R.layout.list_item;
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

        TextView mTextView;

        public Section1Holder(View itemView) {
            super(itemView);

            mTextView = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
