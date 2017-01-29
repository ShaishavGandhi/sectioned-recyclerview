package com.library.shaishavgandhi.samplesectionedrecyclerview.sections;

import android.view.View;

import com.library.sectionedrecyclerview.Section;
import com.library.shaishavgandhi.samplesectionedrecyclerview.R;

/**
 * Created by shaishav.gandhi on 12/11/16.
 */

public class BooksHeader extends Section<MoviesHeader.MiscSectionHolder> {


    @Override
    public void onBind(MoviesHeader.MiscSectionHolder holder, int position) {
        holder.mView.setText("Books");
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
    public MoviesHeader.MiscSectionHolder getViewHolder(View view) {
        return new MoviesHeader.MiscSectionHolder(view);
    }
}
