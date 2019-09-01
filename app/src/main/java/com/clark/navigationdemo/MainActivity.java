package com.clark.navigationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.clark.navigationdemo.act.BottomNavigationViewActivity;
import com.clark.navigationdemo.act.FragmentTabHost2Activity;
import com.clark.navigationdemo.act.FragmentTabHostActivity;
import com.clark.navigationdemo.act.RadioActivity;
import com.clark.navigationdemo.act.TabLayoutActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnFragmentTabHost;
    private Button btnTabVp;
    private Button btnTabLayout;
    private Button btnBottomNavigationView;
    private Button btnRadioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        btnFragmentTabHost = (Button) findViewById(R.id.btn_fragment_tab_host);
        btnTabVp = (Button) findViewById(R.id.btn_tab_vp);
        btnTabLayout = (Button) findViewById(R.id.btn_tab_layout);
        btnBottomNavigationView = (Button) findViewById(R.id.btn_bottom_navigation_view);
        btnRadioGroup = (Button) findViewById(R.id.btn_radio_group);

        btnFragmentTabHost.setOnClickListener(this);
        btnTabVp.setOnClickListener(this);
        btnTabLayout.setOnClickListener(this);
        btnBottomNavigationView.setOnClickListener(this);
        btnRadioGroup.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == btnFragmentTabHost) {
            startActivity(new Intent(MainActivity.this, FragmentTabHostActivity.class));
        } else if (v == btnTabVp) {
            startActivity(new Intent(MainActivity.this, FragmentTabHost2Activity.class));

        } else if (v == btnTabLayout) {
            startActivity(new Intent(MainActivity.this, TabLayoutActivity.class));

        } else if (v == btnBottomNavigationView) {
            startActivity(new Intent(MainActivity.this, BottomNavigationViewActivity.class));

        } else if (v == btnRadioGroup) {
            startActivity(new Intent(MainActivity.this, RadioActivity.class));

        }
    }

}
