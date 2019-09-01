package com.clark.navigationdemo.adp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.clark.navigationdemo.R;

import java.util.List;

public class MyViewPagerAdapter extends FragmentPagerAdapter {
    private List<Class> fragmentClass;
    private List<String> textArray;
    private Context mContext;

    private int[] tabIcon = {R.drawable.icon_menu_home_unsel, R.drawable.icon_menu_project_unsel, R.drawable.icon_menu_mine_unsel};


    public MyViewPagerAdapter(FragmentManager fm, List<Class> fragmentClass, List<String> textArray, Context mContext) {
        super(fm);
        this.fragmentClass = fragmentClass;
        this.textArray = textArray;
        this.mContext = mContext;
    }

    @Override
    public Fragment getItem(int position) {
        return Fragment.instantiate(mContext, fragmentClass.get(position).getCanonicalName());
    }

    @Override
    public int getCount() {
        return textArray.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }

    public View getTabView(int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.tab_layout_item, null, false);
        TextView tv = view.findViewById(R.id.tv);
        ImageView iv = view.findViewById(R.id.iv);
        tv.setText(textArray.get(i));
        iv.setImageResource(tabIcon[i]);
        return view;
    }
}
