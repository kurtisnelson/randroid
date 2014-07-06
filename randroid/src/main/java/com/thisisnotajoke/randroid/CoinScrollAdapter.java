package com.thisisnotajoke.randroid;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.glass.widget.CardScrollAdapter;
import com.kelsonprime.randroid.R;

import java.util.Random;

public class CoinScrollAdapter extends CardScrollAdapter {
    private final Context mContext;
    private static final LinearLayout.LayoutParams PARAMS = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

    public CoinScrollAdapter(Context context) {
        super();
        mContext = context;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        if(convertView == null || !(convertView instanceof LinearLayout)){
            convertView = new LinearLayout(mContext, null);
        }
        LinearLayout layout = (LinearLayout) convertView;
        layout.setLayoutParams(PARAMS);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        ImageView[] coins = getCoinViews(i + 1);
        for(ImageView coin : coins){
            layout.addView(coin);
        }
        return layout;
    }

    @Override
    public int getPosition(Object o) {
        return 0;
    }

    public ImageView[] getCoinViews(int count) {
        Random rnd = new Random();
        ImageView[] list = new ImageView[count];
        for(int i = 0; i < count; i++) {
            list[i] = new ImageView(mContext);
            if (rnd.nextBoolean()) {
                list[i].setImageResource(R.drawable.saca_head);
            } else {
                list[i].setImageResource(R.drawable.saca_tails);
            }
        }
        return list;
    }

}
