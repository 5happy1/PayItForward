package com.cybereyestudios.payitforward;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


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

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.feed_recycler_view);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mDataset = new ArrayList<>();

        // TODO: Query backend for deeds.
        // Sample dataset (for now)
        for (int i = 0; i < 10; i++) {
            mDataset.add(new Deed("Example deed #" + i,
                    "This guy did something really really good. Like really good. [applause]",
                    new User("user"+i, "User #" + i),
                    new ArrayList<User>()));
        }

        mAdapter = new FeedAdapter(mDataset);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);

        return rootView;
    }


}
