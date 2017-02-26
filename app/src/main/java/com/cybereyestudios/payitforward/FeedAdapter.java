package com.cybereyestudios.payitforward;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Adapter for Feed RecyclerView.
 */
public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.DeedHolder> {
    private ArrayList<Deed> deeds;
    private Context context;

    public FeedAdapter(ArrayList<Deed> deeds, Context context) {
        this.deeds = deeds;
        this.context = context;

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
        holder.mAuthorView.setText(deed.author.getRealName());
        holder.mTaggedView.setText(String.format(context.getString(R.string.deed_tagged), deed.taggedUsers.get(0).getRealName()));
    }

    @Override
    public int getItemCount() {
        return deeds.size();
    }

    public class DeedHolder extends RecyclerView.ViewHolder {
        public TextView mTitleView;
        public TextView mDescriptionView;
        public TextView mAuthorView;
        public TextView mTaggedView;

        public DeedHolder(View v) {
            super(v);
            mTitleView = (TextView) v.findViewById(R.id.textView_deed_title);
            mDescriptionView = (TextView) v.findViewById(R.id.textView_deed_description);
            mAuthorView = (TextView) v.findViewById(R.id.textView_deed_author);
            mTaggedView = (TextView) v.findViewById(R.id.textView_deed_tagged);
        }
    }
}

