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
 * Activities that contain this fragment must implement the
 * {@link FeedFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
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
                    new ArrayList<User>()));
        }

        mAdapter = new FeedAdapter(mDataset);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);

        return rootView;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    /**
     * Adapter for Feed RecyclerView.
     */
    public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.DeedHolder> {
        private ArrayList<Deed> deeds;

        public FeedAdapter(ArrayList<Deed> deeds) {
            this.deeds = deeds;
        }

        @Override
        public DeedHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            DeedHolder deedHolder;
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());

            View v = inflater.inflate(R.layout.card_deed, parent, false);
            deedHolder = new DeedHolder(v);
            return deedHolder;
        }

        @Override
        public void onBindViewHolder(DeedHolder holder, int position) {
            Deed deed = deeds.get(position);
            holder.mTitleView.setText(deed.title);
            holder.mDescriptionView.setText(deed.description);
        }

        @Override
        public int getItemCount() {
            return deeds.size();
        }

        public class DeedHolder extends RecyclerView.ViewHolder {
            public TextView mTitleView;
            public TextView mDescriptionView;

            public DeedHolder(View v) {
                super(v);
                mTitleView = (TextView) v.findViewById(R.id.textView_deed_title);
                mDescriptionView = (TextView) v.findViewById(R.id.textView_deed_description);
            }
        }
    }
}
