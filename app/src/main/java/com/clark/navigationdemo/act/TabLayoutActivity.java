package com.clark.navigationdemo.act;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.clark.navigationdemo.R;
import com.clark.navigationdemo.adp.MyViewPagerAdapter;
import com.clark.navigationdemo.frag.FirstFragment;
import com.clark.navigationdemo.frag.SecondFragment;
import com.clark.navigationdemo.frag.ThirdFragment;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutActivity extends AppCompatActivity {


    ViewPager vp;
    TabLayout tabLayout;

    private List<String> textArray = new ArrayList<>();
    private List<Class> clazz = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        vp=findViewById(R.id.vp_pager);
        tabLayout=findViewById(R.id.tab_layout);

        init();
    }

    private void init() {
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager(), clazz, textArray, this);
        initData();
        vp.setAdapter(adapter);
        tabLayout.setupWithViewPager(vp);
        for (int i = 0; i < adapter.getCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(adapter.getTabView(i));
            }
        }
    }

    private void initData() {
        textArray.add("美女");
        textArray.add("足球");
        textArray.add("旅游");

        clazz.add(FirstFragment.class);
        clazz.add(SecondFragment.class);
        clazz.add(ThirdFragment.class);
    }
}
