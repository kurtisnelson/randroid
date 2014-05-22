package com.kelsonprime.randroid;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ResourceListAdapter extends BaseAdapter {

    private final int[] mList;
    private final Context mContext;

    public ResourceListAdapter(Context c, int[] list) {
        super();
        mList = list;
        mContext = c;
    }

    @Override
    public int getCount() {
        return mList.length;
    }

    @Override
    public Object getItem(int i) {
        return mList[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        if(convertView == null)
            convertView = new ImageView(mContext);
        ImageView view = (ImageView) convertView;
        view.setImageResource(mList[i]);
        return view;
    }
}
