package com.example.shaishavgandhi.samplesectionedrecyclerview.sections;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.sectionedrecyclerview.Section;
import com.example.shaishavgandhi.samplesectionedrecyclerview.R;

import java.util.List;

/**
 * Created by shaishav.gandhi on 11/23/16.
 */

public class MoviesHeader extends Section<MoviesHeader.MiscSectionHolder> {

    public MoviesHeader() {
    }

    @Override
    public void onBind(MiscSectionHolder holder, int position) {
        // Do nothing
    }

    @Override
    public int getLayout() {
        return R.layout.list_item_header;
    }

    @Override
    public int getItemCount() {
        return 1;
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
