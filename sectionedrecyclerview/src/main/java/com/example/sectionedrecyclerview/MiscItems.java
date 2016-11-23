package com.example.sectionedrecyclerview;

import android.support.v7.widget.RecyclerView;

/**
 * Created by shaishav.gandhi on 11/23/16.
 */

public interface MiscItems<VH extends RecyclerView.ViewHolder> {

    VH createMiscItemHolder();
    void bindMiscItem(VH vh, int position);

}
