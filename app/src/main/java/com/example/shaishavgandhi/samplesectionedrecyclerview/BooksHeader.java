package com.example.shaishavgandhi.samplesectionedrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.sectionedrecyclerview.Section;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shaishav.gandhi on 12/11/16.
 */

public class BooksHeader extends Section<HeaderSection.MiscSectionHolder> {


    @Override
    public void onBind(HeaderSection.MiscSectionHolder holder, int position) {
        holder.mView.setText("Books");
    }

    @Override
    public int getLayout() {
        return R.layout.list_item_header;
    }

    @Override
    public List<?> getData() {
        return null;
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public HeaderSection.MiscSectionHolder getViewHolder(View view) {
        return new HeaderSection.MiscSectionHolder(view);
    }
}
