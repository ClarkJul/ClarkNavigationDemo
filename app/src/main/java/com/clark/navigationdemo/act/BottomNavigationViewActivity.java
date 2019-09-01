package com.clark.navigationdemo.act;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.clark.navigationdemo.R;
import com.clark.navigationdemo.adp.MyViewPagerAdapter;
import com.clark.navigationdemo.frag.FirstFragment;
import com.clark.navigationdemo.frag.SecondFragment;
import com.clark.navigationdemo.frag.ThirdFragment;

import java.util.Arrays;

public class BottomNavigationViewActivity extends AppCompatActivity {

    ViewPager vp;
    BottomNavigationView bnv;

    private String[] textViewArray = {"美女", "足球", "旅游"};
    private Class[] fragmentClass = {FirstFragment.class, SecondFragment.class, ThirdFragment.class};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_view);

        vp=findViewById(R.id.vp_pager);
        bnv=findViewById(R.id.bnv);
        init();
    }

    private void init() {
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager(), Arrays.asList(fragmentClass), Arrays.asList(textViewArray), this);
        vp.setAdapter(adapter);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bnv.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.taobao:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.jingdong:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.yamaxun:
                        vp.setCurrentItem(2);
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
    }
}
