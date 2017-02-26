package com.cybereyestudios.payitforward;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FeedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FeedFragment extends Fragment {
    protected RecyclerView mRecyclerView;
    protected FeedAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected ArrayList<Deed> mDataset;

    public FeedFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FeedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FeedFragment newInstance() {
        FeedFragment fragment = new FeedFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_feed, container, false);
        getString(R.string.deed_tagged);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.feed_recycler_view);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mDataset = new ArrayList<>();

        // TODO: Query backend for deeds.
        // Sample dataset (for now)
        for (int i = 0; i < 10; i++) {
            mDataset.add(new Deed("Example deed #" + i,
                    "I did something really good and I want recognition for it. Please clap.",
                    new User("user"+i, "User #" + i),
                    new ArrayList<User>(Arrays.asList(new User("user" + (i + 10), "User #" + (i + 10))))));
        }

        mAdapter = new FeedAdapter(mDataset, getContext());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);

        return rootView;
    }


}
