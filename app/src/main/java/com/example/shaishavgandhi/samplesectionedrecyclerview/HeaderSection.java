package com.example.shaishavgandhi.samplesectionedrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.sectionedrecyclerview.Section;

import java.util.List;

/**
 * Created by shaishav.gandhi on 11/23/16.
 */

public class HeaderSection extends Section<HeaderSection.MiscSectionHolder> {


    private List<String> mData;

    public HeaderSection(List<String> mData) {
        this.mData = mData;
    }

    @Override
    public void onBind(MiscSectionHolder holder, int position) {
        // Do nothing
        holder.getAdapterPosition();
    }

    @Override
    public int getLayout() {
        return R.layout.list_item_header;
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

        TextView mView;

        public MiscSectionHolder(View itemView) {
            super(itemView);
            mView = (TextView) itemView.findViewById(R.id.header);
        }
    }
}
