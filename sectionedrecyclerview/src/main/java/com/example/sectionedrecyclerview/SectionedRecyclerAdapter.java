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
//    NavigableMap<Integer, Section> mSections;
    List<Section> mSections;

    public SectionedRecyclerAdapter(Context context) {
        mContext = context;
        mMiscSections = new HashMap<>();
        mSections = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {
        if (mMiscSections != null && mMiscSections.containsKey(position)) {
            return  13 * (position + 1);
        }

        position = getRefactoredPosition(position);
        SectionMap sectionMap = getSectionMap(position);
        return mSections.indexOf(sectionMap.getSection());
    }

    @Override
    public int getItemCount() {
        int count = 0;
        if (mMiscSections != null) {
            count = mMiscSections.size();
        }

        for (int i = 0; i < mSections.size(); i++) {
            count += mSections.get(i).getItemCount();
        }

        return count;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Section section = null;

        // Misc Section In Between
        if (viewType != 0 && viewType % 13 == 0) {
            section = mMiscSections.get((viewType / 13) - 1);
        } else {
            section = mSections.get(viewType);
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
            SectionMap sectionMap = getSectionMap(position);
            sectionMap.getSection().onBind(holder, position - sectionMap.getStartPosition());
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
        mSections.add(section);
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

    public void removeSectionAt(int position) {
        mSections.remove(position);
    }

    public void notifySectionInserted(int position) {
        Section section = mSections.get(position);
        notifySectionInserted(section);
    }

    public void notifySectionInserted(Section section) {
        SectionMap sectionMap = getSectionMap(section);
        notifyItemRangeInserted(sectionMap.getStartPosition(), sectionMap.getStartPosition() + sectionMap.getSection().getItemCount());
    }

    public void notifySectionChanged(int position) {
        Section section = mSections.get(position);
        notifySectionChanged(section);
    }

    public void notifySectionChanged(Section section) {
        SectionMap sectionMap = getSectionMap(section);
        notifyItemRangeChanged(sectionMap.getStartPosition(), sectionMap.getStartPosition() + sectionMap.getSection().getItemCount());
    }

    public void notifySectionRemoved(int position, int itemCount) {
        SectionMap sectionMap = getSectionMap(mSections.get(position - 1));
        int startPosition = sectionMap.getStartPosition() + sectionMap.getSection().getItemCount();
        notifyItemRangeRemoved(startPosition, startPosition + itemCount);
    }

    public void notifySectionItemChanged(int position) {
        SectionMap sectionMap = getSectionMap(position);
        notifyItemChanged(sectionMap.getStartPosition() + position);
    }

    public void notifySectionItemRangeChanged(int startPosition, int lastPosition) {
        SectionMap sectionMap = getSectionMap(startPosition);
        notifyItemRangeChanged(sectionMap.getStartPosition() + startPosition, sectionMap.getStartPosition() + lastPosition);
    }

    public void notifySectionItemInserted(int position) {
        SectionMap sectionMap = getSectionMap(position);
        notifyItemInserted(sectionMap.getStartPosition() + position);
    }

    public void notifySectionItemRangeInserted(int startPosition, int lastPosition) {
        SectionMap sectionMap = getSectionMap(startPosition);
        notifyItemRangeInserted(sectionMap.getStartPosition() + startPosition, sectionMap.getStartPosition() + lastPosition);
    }

    public void notifySectionItemRemoved(int position) {
        SectionMap sectionMap = getSectionMap(position);
        notifyItemRemoved(sectionMap.getStartPosition() + position);
    }

    public void notifySectionItemRangeRemoved(int startPosition, int lastPosition) {
        SectionMap sectionMap = getSectionMap(startPosition);
        notifyItemRangeRemoved(sectionMap.getStartPosition() + startPosition, sectionMap.getStartPosition() + lastPosition);
    }

    private SectionMap getSectionMap(int position) {
        int count = 0;
        SectionMap sectionMap = null;
        for (int i = 0; i < mSections.size(); i++) {
            count += mSections.get(i).getItemCount();
            if (position < count) {
                sectionMap = new SectionMap(count - mSections.get(i).getItemCount(), mSections.get(i));
            }
        }
        return sectionMap;
    }

    private SectionMap getSectionMap(Section section) {
        int count = 0;
        SectionMap sectionMap = null;
        for (int i = 0; i < mSections.size(); i++) {
            count += mSections.get(i).getItemCount();
            if (mSections.get(i).equals(section)) {
                sectionMap = new SectionMap(count - mSections.get(i).getItemCount(), mSections.get(i));
            }
        }
        return sectionMap;
    }
}
