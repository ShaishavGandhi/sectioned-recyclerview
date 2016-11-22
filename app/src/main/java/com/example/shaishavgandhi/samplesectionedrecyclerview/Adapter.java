package com.example.shaishavgandhi.samplesectionedrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.example.sectionedrecyclerview.SectionedRecyclerAdapter;

import java.util.List;

/**
 * Created by shaishav.gandhi on 11/19/16.
 */

public class Adapter extends SectionedRecyclerAdapter<RecyclerView.ViewHolder> {


    public Adapter(Context context, List<String> mData, List<String> mData2) {
        super(context);

        addSection(new Section1(context, mData));
        addSection(new Section2(context, mData2));
        addSection(new Section1(context, mData));
        addSection(new Section2(context, mData2));
    }

}
