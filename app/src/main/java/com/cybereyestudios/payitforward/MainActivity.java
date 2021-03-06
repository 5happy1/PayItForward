package com.cybereyestudios.payitforward;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FrameLayout fragContainer;

    MenuItem selectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set view fields
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        fragContainer = (FrameLayout) findViewById(R.id.fragment_container);

        // Create first feed fragment
        FeedFragment firstFeedFrag = FeedFragment.newInstance();
        getSupportFragmentManager().beginTransaction().addToBackStack(null).add(R.id.fragment_container, firstFeedFrag, firstFeedFrag.getTag()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        selectedItem = item;
                        selectFragment(selectedItem);
                        return true;
                    }
                }
        );
    }

    /**
     * Select appropriate fragment based on item selected.
     * @param item Item that was selected
     */
    private void selectFragment(MenuItem item) {
        Fragment frag = null;
        Fragment currentFrag = getSupportFragmentManager().findFragmentById(R.id.fragment_container);

        switch (item.getItemId()) {
            case R.id.tab_feed:
                if (!(currentFrag instanceof FeedFragment)) {
                    frag = FeedFragment.newInstance();
                }
                break;
            case R.id.tab_explore:
                if (!(currentFrag instanceof ExploreFragment)) {
                    frag = ExploreFragment.newInstance();
                }
                break;
            case R.id.tab_notifications:
                if (!(currentFrag instanceof NotificationsFragment)) {
                    frag = NotificationsFragment.newInstance();
                }
                break;
            case R.id.tab_profile:
                if (!(currentFrag instanceof ProfileFragment)) {
                    frag = ProfileFragment.newInstance();
                }
                break;
        }

        if (frag != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            ft.addToBackStack(null);
            ft.replace(R.id.fragment_container, frag, frag.getTag());
            ft.commit();
        }
    }

    /**
     * Update bottom navigation view on back pressed.
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (selectedItem != null && selectedItem.getItemId() != bottomNavigationView.getMenu().getItem(0).getItemId()){
            selectFragment(bottomNavigationView.getMenu().getItem(0));
        }
//        updateBottomNav(selectedItem);
    }

    private void updateBottomNav(MenuItem item) {

        if (item != null) {
//            System.out.println(item.getItemId());
//            for (int i = 0; i < bottomNavigationView.getMenu().size(); i++) {
//                MenuItem menuItem = bottomNavigationView.getMenu().getItem(i);
//                System.out.println(menuItem.getItemId());
//                System.out.println(menuItem.getItemId() == item.getItemId());
//                menuItem.setChecked(false);
//            }
        }
    }

}
