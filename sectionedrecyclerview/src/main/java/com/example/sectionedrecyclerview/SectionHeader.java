package com.example.sectionedrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by shaishav.gandhi on 11/23/16.
 */

public interface SectionHeader<VH extends RecyclerView.ViewHolder> {

    VH createHeaderHolder(ViewGroup parent, int viewType);
    void bindHeader(VH vh);

}
