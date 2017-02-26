package com.cybereyestudios.payitforward;

import android.content.Context;
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
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    CurrentUser currentUser;
    TextView profileName, profileEmail;
    RecyclerView userDeedsView;
    FeedAdapter deedsViewAdapter;
    RecyclerView.LayoutManager deedsViewLayoutManager;
    ArrayList<Deed> userDeeds;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FeedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        currentUser = new CurrentUser("johnsmith12", "John Smith", "johnsmith@example.com");

        // Populate text views
        profileName = (TextView) rootView.findViewById(R.id.textView_profile_name);
        profileName.setText(currentUser.getRealName());

        profileEmail = (TextView) rootView.findViewById(R.id.textView_profile_email);
        profileEmail.setText(currentUser.getEmail());

        userDeedsView = (RecyclerView) rootView.findViewById(R.id.profile_recycler_view);
        deedsViewLayoutManager = new LinearLayoutManager(getActivity());
        userDeedsView.setLayoutManager(deedsViewLayoutManager);

        userDeeds = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            userDeeds.add(new Deed("Pet " + (int)(Math.random() * 30) + " cats",
                    "Today I pet a lot of cats! They were so cute!!!11!",
                    new User("johnsmith12", "John Smith"), new ArrayList<User>()));
        }

        deedsViewAdapter = new FeedAdapter(userDeeds);
        userDeedsView.setAdapter(deedsViewAdapter);

        return rootView;
    }

    public class CurrentUser extends User {
        String email;

        CurrentUser(String username, String realName, String email) {
            this.username = username;
            this.realName = realName;
            this.email = email;
        }

        public String getEmail() {
            return email;
        }
    }
}
