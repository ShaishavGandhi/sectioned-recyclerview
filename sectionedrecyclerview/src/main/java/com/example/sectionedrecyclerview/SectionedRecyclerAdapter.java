package com.example.sectionedrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Created by shaishav.gandhi on 11/19/16.
 */

public abstract class SectionedRecyclerAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    Context mContext;
    HashMap<Integer, ?> mMiscItems;
    NavigableMap<Integer, Section> mSections;

    public SectionedRecyclerAdapter(Context context) {
        mContext = context;
        mMiscItems = new HashMap<>();
        mSections = new TreeMap<>();
    }

    @Override
    public int getItemViewType(int position) {
        return mSections.floorEntry(position).getKey();
    }

    @Override
    public int getItemCount() {
        return mSections.lastKey() + mSections.lastEntry().getValue().getItemCount();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        Section section = mSections.floorEntry(viewType).getValue();
        View view = inflater.inflate(section.getLayout(), parent, false);
        return (VH)section.getViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        Section section = mSections.floorEntry(position).getValue();
        int offsetPosition = position - mSections.floorEntry(position).getKey();
        section.onBind(holder, offsetPosition);
    }

    public void addSection(Section section) {
        if (mSections.size() == 0) {
            mSections.put(0, section);
        } else {
            int newKey = mSections.lastEntry().getKey() + mSections.lastEntry().getValue().getItemCount();
            mSections.put(newKey, section);
        }
    }

    public void addSections(List<Section> sectionList) {
        for (int i = 0; i < sectionList.size(); i++) {
            addSection(sectionList.get(i));
        }
    }
}
