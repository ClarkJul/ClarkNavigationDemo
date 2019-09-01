package com.clark.navigationdemo.act;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.clark.navigationdemo.R;
import com.clark.navigationdemo.frag.FirstFragment;
import com.clark.navigationdemo.frag.ForthFragment;
import com.clark.navigationdemo.frag.SecondFragment;
import com.clark.navigationdemo.frag.ThirdFragment;

import java.util.ArrayList;
import java.util.List;

public class RadioActivity extends AppCompatActivity {


    private RadioGroup radioGroup;
    private FragmentManager fragmentManager;
    private List<Fragment> fragmentList;
    private RadioButton homeRadioButton;
    private RadioButton mineRadioButton;
    private int currentSelectedId = R.id.rb_home;
    private SecondFragment secondFragment;
    private ThirdFragment thirdFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

        radioGroup = findViewById(R.id.rg_radio_group);
        homeRadioButton = findViewById(R.id.rb_home);
        mineRadioButton = findViewById(R.id.rb_mine);


        fragmentManager = getSupportFragmentManager();
        createFragment();
        selectFragment(0);
        homeRadioButton.setChecked(true);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == currentSelectedId) {
                    return;
                }
                currentSelectedId = checkedId;
                if (checkedId == R.id.rb_home) {
                    selectFragment(0);
                } else if (checkedId == R.id.rb_project) {
                    selectFragment(1);
                } else if (checkedId == R.id.rb_system) {
                    selectFragment(2);
                } else if (checkedId == R.id.rb_mine) {
                    selectFragment(3);

                }
            }
        });
    }

    private void createFragment() {
        fragmentList = new ArrayList<>();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        FirstFragment firstFragment = new FirstFragment();
        ft.add(R.id.fl_main_container, firstFragment);
        fragmentList.add(firstFragment);

        secondFragment = new SecondFragment();
        ft.add(R.id.fl_main_container, secondFragment);
        fragmentList.add(secondFragment);

        thirdFragment = new ThirdFragment();
        ft.add(R.id.fl_main_container, thirdFragment);
        fragmentList.add(thirdFragment);

        ForthFragment mineFragment = new ForthFragment();
        ft.add(R.id.fl_main_container, mineFragment);
        fragmentList.add(mineFragment);

        // 提交事务
        ft.commit();
    }


    /**
     * 选中某个 Fragment
     *
     * @param index
     */
    private void selectFragment(int index) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        for (int i = 0; i < fragmentList.size(); i++) {
            if (i == index) {
                ft.show(fragmentList.get(i));
            } else {
                ft.hide(fragmentList.get(i));
            }
        }
        ft.commit();
    }
}
