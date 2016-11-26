package com.example.sectionedrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Created by shaishav.gandhi on 11/19/16.
 */

public abstract class SectionedRecyclerAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    Context mContext;
    HashMap<Integer, Section> mMiscSections;
    NavigableMap<Integer, Section> mSections;

    public SectionedRecyclerAdapter(Context context) {
        mContext = context;
        mMiscSections = new HashMap<>();
        mSections = new TreeMap<>();
    }

    @Override
    public int getItemViewType(int position) {
        if (mMiscSections != null && mMiscSections.containsKey(position)) {
            return  13 * (position + 1);
        }

        position = getRefactoredPosition(position);
        return (mSections.floorEntry(position).getKey() + 1) * 11;
    }

    @Override
    public int getItemCount() {
        int count = 0;
        if (mMiscSections != null) {
            count = mMiscSections.size();
        }
        return mSections.lastKey() + mSections.lastEntry().getValue().getItemCount() + count;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Section section = null;

        // Misc Section In Between
        if (viewType % 13 == 0) {
            section = mMiscSections.get((viewType / 13) - 1);
        } else {
            section = mSections.floorEntry(viewType / 11).getValue();
        }

        View view = inflater.inflate(section.getLayout(), parent, false);
        return (VH)section.getViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        if (mMiscSections != null && mMiscSections.containsKey(position)) {
            Section section = mMiscSections.get(position);
            section.onBind(holder, position);
        } else {
            position = getRefactoredPosition(position);
            Section section = mSections.floorEntry(position).getValue();
            int offsetPosition = position - mSections.floorEntry(position).getKey();
            section.onBind(holder, offsetPosition);
        }
    }

    private int getRefactoredPosition(int position) {
        int offset = 0;
        for (Map.Entry<Integer, Section> entry : mMiscSections.entrySet()) {
            if (position > entry.getKey()) {
                offset ++;
            }
        }

        return position - offset;
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

    public void addSectionAt(int position, Section section) {
        mMiscSections.put(position, section);
    }

    public void removeSection(Section section) {
        mSections.remove(section);
    }

    public void notifySectionInserted(int position) {
        // Implement method here
    }

    public void notifySectionChanged(int position) {
        int key = (int) mSections.keySet().toArray()[position];

        notifyItemChanged(key, mSections.floorEntry(key).getValue().getItemCount());
    }
}
