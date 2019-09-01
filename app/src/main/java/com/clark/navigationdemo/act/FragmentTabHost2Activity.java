package com.clark.navigationdemo.act;

import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

import com.clark.navigationdemo.R;
import com.clark.navigationdemo.adp.MyViewPagerAdapter;
import com.clark.navigationdemo.frag.FirstFragment;
import com.clark.navigationdemo.frag.SecondFragment;
import com.clark.navigationdemo.frag.ThirdFragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentTabHost2Activity extends AppCompatActivity {

    ViewPager vp;
    FragmentTabHost tabhost;

    private List<String> textArray = new ArrayList<>();
    private List<Class> clazz = new ArrayList<>();
    private int[] tabIcon = {R.drawable.icon_menu_home_unsel, R.drawable.icon_menu_project_unsel, R.drawable.icon_menu_mine_unsel};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_tab_host2);
        vp=findViewById(R.id.vp_pager);
        tabhost=findViewById(android.R.id.tabhost);

        init();
    }

    private void init() {
        tabhost.setup(this, getSupportFragmentManager(), R.id.vp_pager);
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager(), clazz, textArray, this);
        initData();
        vp.setAdapter(adapter);
        int count = textArray.size();
        for (int i = 0; i < count; i++) {
            TabHost.TabSpec tabSpec = tabhost.newTabSpec(textArray.get(i)).setIndicator(getItemView(i));
            tabhost.addTab(tabSpec, clazz.get(i), null);
            tabhost.getTabWidget().getChildTabViewAt(i).setBackgroundResource(R.drawable.tab_item);
        }
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabhost.getTabWidget().setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tabhost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                int pos = tabhost.getCurrentTab();
                vp.setCurrentItem(pos);
            }
        });
    }

    private void initData() {
        textArray.add("美女");
        textArray.add("足球");
        textArray.add("旅游");

        clazz.add(FirstFragment.class);
        clazz.add(SecondFragment.class);
        clazz.add(ThirdFragment.class);
    }

    private View getItemView(int i) {
        View view = LayoutInflater.from(this).inflate(R.layout.fragment_tab_host_item, null, false);
        TextView tv = view.findViewById(R.id.tab_textview);
        tv.setText(textArray.get(i));
        Drawable drawable = ContextCompat.getDrawable(this, tabIcon[i]);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        tv.setCompoundDrawables(null, drawable, null, null);
        return view;
    }
}
