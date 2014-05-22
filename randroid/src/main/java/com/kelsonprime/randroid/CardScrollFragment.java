package com.kelsonprime.randroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.android.glass.widget.CardScrollView;

import java.util.List;


public abstract class CardScrollFragment extends Fragment {
    protected CardScrollView mCardScrollView;

    @Override
    public CardScrollView onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mCardScrollView = new CardScrollView(getActivity());
        ArrayListCardScrollAdapter adapter = new ArrayListCardScrollAdapter<CardScrollable>(createCards());
        mCardScrollView.setAdapter(adapter);
        mCardScrollView.activate();
        return mCardScrollView;
    }

    protected abstract List<CardScrollable> createCards();
}