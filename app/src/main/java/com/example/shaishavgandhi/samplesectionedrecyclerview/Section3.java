package com.example.shaishavgandhi.samplesectionedrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.sectionedrecyclerview.Section;

import java.util.List;

/**
 * Created by shaishav.gandhi on 11/23/16.
 */

public class Section3 extends Section<Section3.MiscSectionHolder> {


    private List<String> mData;

    public Section3(List<String> mData) {
        this.mData = mData;
    }

    @Override
    public void onBind(MiscSectionHolder holder, int position) {
        // Do nothing
        holder.getAdapterPosition();
    }

    @Override
    public int getLayout() {
        return R.layout.list_misc_item;
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
    public MiscSectionHolder getViewHolder(View view) {
        return new MiscSectionHolder(view);
    }

    public static class MiscSectionHolder extends RecyclerView.ViewHolder {

        public MiscSectionHolder(View itemView) {
            super(itemView);
        }
    }
}
