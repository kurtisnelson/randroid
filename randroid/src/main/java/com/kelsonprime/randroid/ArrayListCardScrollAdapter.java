package com.kelsonprime.randroid;

import android.view.View;
import android.view.ViewGroup;

import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollAdapter;

import java.util.List;


public class ArrayListCardScrollAdapter<T extends CardScrollable> extends CardScrollAdapter {
    private List<T> mList;
    private int mHomePosition;

    public ArrayListCardScrollAdapter(List<T> list){
        this(list, 0);
    }
    public ArrayListCardScrollAdapter(List<T> list, int homePosition){
        mList = list;
        mHomePosition = homePosition;
    }

    @Override
    public int getPosition(Object item) {
        return mList.indexOf(item);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getViewTypeCount() {
        return Card.getViewTypeCount();
    }

    @Override
    public int getItemViewType(int position){
        return mList.get(position).getItemViewType();
    }

    @Override
    public View getView(int position, View convertView,
                        ViewGroup parent) {
        return  mList.get(position).getView(convertView, parent);
    }

    @Override
    public int getHomePosition() {
        return mHomePosition;
    }
}