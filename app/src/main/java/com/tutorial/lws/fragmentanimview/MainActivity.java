package com.tutorial.lws.fragmentanimview;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();// method to find xml views by id

        setSupportActionBar(toolbar);

        setupViewPager(viewPager);//method to set adapter on view pager

        tabLayout.setupWithViewPager(viewPager);// sync the tab layout with the viewpager

        setupTabIcons(); //method to set icons in TabLayout
    }

    private void findViews() {
        toolbar=findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
    }

    private void setupViewPager(ViewPager viewPager) {

        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(this,getSupportFragmentManager());//create object of fragment adapter
        adapter.addFragment(new OneFragment(), "ONE");     //adding fragments to fragment arraylist in adapter via addFragment public method
        adapter.addFragment(new TwoFragment(), "TWO");
        adapter.addFragment(new ThreeFragment(), "THREE");
        adapter.addFragment(new FourFragment(),"FOUR");
        adapter.addFragment(new FiveFragment(),"FIVE");
        viewPager.setAdapter(adapter);// setting adapter to viewpager
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_one);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_two);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_three);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_four);
        tabLayout.getTabAt(4).setIcon(R.drawable.ic_five);
    }


}
