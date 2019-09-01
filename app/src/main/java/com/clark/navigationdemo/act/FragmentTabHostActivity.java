package com.clark.navigationdemo.act;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.clark.navigationdemo.R;
import com.clark.navigationdemo.frag.FirstFragment;
import com.clark.navigationdemo.frag.SecondFragment;
import com.clark.navigationdemo.frag.ThirdFragment;

public class FragmentTabHostActivity extends AppCompatActivity {

    private FragmentTabHost tabhost;

    private String[] textViewArray = {"首页", "项目", "我的"};
    private Class[] fragmentClass = {FirstFragment.class, SecondFragment.class, ThirdFragment.class};
    private int[] tabIcon = {R.drawable.icon_menu_home_unsel, R.drawable.icon_menu_project_unsel, R.drawable.icon_menu_mine_unsel};

    private void findViews() {
        tabhost = (FragmentTabHost) findViewById(android.R.id.tabhost);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_tab_host);
        setTitle("FragmentTabHost");
        findViews();
        init();
    }

    private void init() {

        tabhost.setup(this, getSupportFragmentManager(), R.id.real_content);
        int count = textViewArray.length;
        for (int i = 0; i < count; i++) {
            // Tab按钮添加文字和图片
            TabHost.TabSpec tabSpec = tabhost.newTabSpec(textViewArray[i]).setIndicator(getItemView(i));
            // 添加Fragment
            tabhost.addTab(tabSpec, fragmentClass[i], null);
            // 设置Tab按钮的背景
            tabhost.getTabWidget().getChildTabViewAt(i).setBackgroundResource(R.drawable.tab_item);
        }
    }

    private View getItemView(int i) {
        View view = LayoutInflater.from(this).inflate(R.layout.fragment_tab_host_item, null, false);
        TextView tv = view.findViewById(R.id.tab_textview);
        tv.setText(textViewArray[i]);
        Drawable drawable = ContextCompat.getDrawable(this, tabIcon[i]);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        tv.setCompoundDrawables(null, drawable, null, null);
        return view;
    }
}
