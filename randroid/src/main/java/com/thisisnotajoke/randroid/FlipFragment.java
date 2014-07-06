package com.thisisnotajoke.randroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.google.android.glass.widget.CardScrollView;
import com.kelsonprime.randroid.R;

public class FlipFragment extends Fragment {

    private static final String PARAM_COUNT = "FlipFragment.count";
    private static final String TAG = "FlipFragment";
    private int mCount;
    private CardScrollView mScrollView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCount = getArguments().getInt(PARAM_COUNT, 1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        mScrollView = (CardScrollView) view.findViewById(R.id.fragment_result_card_scroll);

        mScrollView.setAdapter(new CoinScrollAdapter(getActivity()));
        mScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getActivity().openOptionsMenu();
            }
        });
        mScrollView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                new PreferenceManager(getActivity()).setCoins(position + 1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mScrollView.activate();
        mScrollView.setSelection(mCount - 1);
    }

    @Override
    public void onStop() {
        super.onStop();
        mScrollView.deactivate();
    }

    public static FlipFragment newInstance(int count) {
        FlipFragment fragment = new FlipFragment();

        Bundle args = new Bundle();
        args.putInt(PARAM_COUNT, count);
        fragment.setArguments(args);

        return fragment;
    }
}
