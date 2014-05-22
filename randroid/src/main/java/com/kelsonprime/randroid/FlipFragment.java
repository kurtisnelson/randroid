package com.kelsonprime.randroid;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.google.android.glass.media.Sounds;

import java.util.Random;

public class FlipFragment extends Fragment {

    private static final String PARAM_COUNT = "FlipFragment.count";
    private int mCount;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCount = getArguments().getInt(PARAM_COUNT, 1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        GridView resultGrid = (GridView) view.findViewById(R.id.fragment_result_grid);

        Random rnd = new Random();
        int[] list = new int[mCount];
        for(int i = 0; i < mCount; i++) {
            if(rnd.nextBoolean()){
                list[i] = R.drawable.quarter_head;
            }else{
                list[i] = R.drawable.quarter_tails;
            }
        }

        resultGrid.setAdapter(new ResourceListAdapter(getActivity(), list));
        resultGrid.setNumColumns(list.length);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        AudioManager audio = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
        audio.playSoundEffect(Sounds.SELECTED);
    }

    public static FlipFragment newInstance(int count) {
        FlipFragment fragment = new FlipFragment();

        Bundle args = new Bundle();
        args.putInt(PARAM_COUNT, count);
        fragment.setArguments(args);

        return fragment;
    }
}
