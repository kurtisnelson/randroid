package com.kelsonprime.randroid;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollView;

import java.util.ArrayList;

public class CoinScrollFragment extends CardScrollFragment {
    ArrayList<CardScrollable> cards;

    @Override
    public CardScrollView onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        CardScrollView v = super.onCreateView(inflater, container, savedInstanceState);
        v.setHorizontalScrollBarEnabled(true);
        v.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CoinCard selectedCard = (CoinCard) mCardScrollView.getSelectedItem();
                new PreferenceManager(getActivity()).setCoins(selectedCard.getCount());
            }
        });
        v.setSelection(new PreferenceManager(getActivity()).getCoins());
        return v;
    }

    @Override
    protected ArrayList<CardScrollable> createCards() {
        if(cards == null){
            cards = new ArrayList<CardScrollable>();
            cards.add(new CoinCard(1));
            cards.add(new CoinCard(2));
        }
        return cards;
    }

    private class CoinCard implements CardScrollable {
        private Card mCard;
        private int mCount;

        public CoinCard(int count) {
            mCount = count;
            mCard = new Card(getActivity().getBaseContext());
            Resources res = getResources();
            String coins = res.getQuantityString(R.plurals.coin, count, count);
            mCard.setFootnote(coins);
            for(int i = 0; i < count; i++){
                if(i % 2 == 0) {
                    mCard.addImage(R.drawable.quarter_head);
                } else {
                    mCard.addImage(R.drawable.quarter_tails);
                }
            }
            mCard.setImageLayout(Card.ImageLayout.FULL);
        }

        @Override
        public int getItemViewType() {
            return 0;
        }

        @Override
        public View getView(View convertView, ViewGroup parent) {
            return mCard.getView(convertView, parent);
        }

        public int getCount() {
            return mCount;
        }
    }
}
