package com.example.sportsbuddy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;


import com.example.sportsbuddy.Fragments.ChatFragment;
import com.example.sportsbuddy.Fragments.UsersFragment;


import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class UsersActivity extends AppCompatActivity {


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_users );
        TabLayout tablayout=findViewById ( R.id.tab_layout );
        ViewPager viewPager=findViewById ( R.id.view_pager );
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter ( getSupportFragmentManager () );
        viewPagerAdapter.addFragment ( new ChatFragment (),"Chats" );
        viewPagerAdapter.addFragment ( new UsersFragment (),"Users" );
        viewPager.setAdapter (viewPagerAdapter  );
        tablayout.setupWithViewPager (viewPager  );

    }
    class ViewPagerAdapter extends FragmentPagerAdapter{
private ArrayList<Fragment> fragments;
private ArrayList<String> titles;
ViewPagerAdapter(FragmentManager fn){
    super(fn);
    this.fragments=new ArrayList<> (  );
    this.titles=new ArrayList<> (  );
}
        @NonNull
        @Override
        public Fragment getItem (int position) {
            return fragments.get ( position );
        }

        @Override
        public int getCount () {
            return fragments.size ();
        }
        public void addFragment(Fragment fragment,String title){
    fragments.add ( fragment );
    titles.add ( title );
        }

        @Nullable
        @Override
        public CharSequence getPageTitle (int position) {
            return titles.get ( position );
        }
    }
}
