package com.example.sectionedrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shaishav.gandhi on 11/19/16.
 */

public abstract class SectionedRecyclerAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    List<Section> mSections;
    Context mContext;

    public SectionedRecyclerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getItemViewType(int position) {
        int count = mSections.get(0).getItemCount();

        if (position < count) {
            return 0;
        }

        for (int i = 1; i < mSections.size(); i++) {
            count += mSections.get(i).getItemCount();
            if (position < count) {
                return 2 * i;
            }
        }

        return count;
    }

    @Override
    public int getItemCount() {
        int count = 0;

        for (int i = 0; i < mSections.size(); i++) {
            count += mSections.get(i).getItemCount();
        }

        return count;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        Section section = mSections.get(viewType / 2);
        View view = inflater.inflate(section.getLayout(), parent, false);
        return (VH)section.getViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        getSection(position).onBind(holder, getSectionOffsetedPosition(position));
    }

    public void addSection(Section section) {
        if (mSections == null) {
            mSections = new ArrayList<>();
        }

        mSections.add(section);

    }

    public void addSection(Section section, int position) {
        if (mSections == null) {
            mSections = new ArrayList<>();
        }

        mSections.add(position, section);
    }

    public void addSections(List<Section> sectionList) {
        if (mSections == null) {
            mSections = new ArrayList<>();
        }

        mSections.addAll(sectionList);
    }

    public void removeSection(int position) {
        if (position < mSections.size()) {
            mSections.remove(position);
        }
    }

    public void replaceSection(Section section, int position) {
        if (position < mSections.size()) {
            mSections.remove(position);
            addSection(section, position);
        }
    }

    private int getSectionOffsetedPosition(int position) {
        int count = mSections.get(0).getItemCount();

        if (position < count) {
            return position;
        }

        for (int i = 1; i < mSections.size(); i++) {
            count += mSections.get(i).getItemCount();
            if (position < count) {
                return mSections.get(i).getItemCount() - (count - position);
            }
        }

        return position;
    }

    private Section getSection(int position) {
        int count = mSections.get(0).getItemCount();

        if (position < count) {
            return mSections.get(0);
        }

        for (int i = 1; i < mSections.size(); i++) {
            count += mSections.get(i).getItemCount();
            if (position < count) {
                return mSections.get(i);
            }
        }

        return mSections.get(0);
    }

}
