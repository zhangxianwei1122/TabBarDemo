package com.zxw.tabbardemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.PopupWindow;

import com.startsmake.mainnavigatetabbar.widget.MainNavigateTabBar;
import com.zxw.tabbardemo.fragment.Data;
import com.zxw.tabbardemo.fragment.HomeFragment;
import com.zxw.tabbardemo.fragment.PersonFragment;
import com.zxw.tabbardemo.fragment.PubltshFragment;
import com.zxw.tabbardemo.fragment.PurchaseFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG_PAGE_HOME = "首页";
    private static final String TAG_PAGE_PURCHASE = "购买";
    private static final String TAG_PAGE_PUBLISH = "发布";
    private static final String TAG_PAGE_FOLLOW = "关注";
    private static final String TAG_PAGE_PERSON = "我的";

    private MainNavigateTabBar mainNavigateTabBar;
    private List<Data> list;
    private int popupWidth;
    private int popupHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainNavigateTabBar = (MainNavigateTabBar) findViewById(R.id.mainTabBar);
        mainNavigateTabBar.onRestoreInstanceState(savedInstanceState);

        mainNavigateTabBar.addTab(HomeFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.comui_tab_home, R.mipmap.comui_tab_home_selected, TAG_PAGE_HOME));
        mainNavigateTabBar.addTab(PurchaseFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.comui_tab_city, R.mipmap.comui_tab_city_selected, TAG_PAGE_PURCHASE));
        mainNavigateTabBar.addTab(null, new MainNavigateTabBar.TabParam(0, 0, TAG_PAGE_PUBLISH));
        mainNavigateTabBar.addTab(PubltshFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.comui_tab_message, R.mipmap.comui_tab_message_selected, TAG_PAGE_FOLLOW));
        mainNavigateTabBar.addTab(PersonFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.comui_tab_person, R.mipmap.comui_tab_person_selected, TAG_PAGE_PERSON));
    }

    public void onClickPublish(View v) {
        showPopuwindow(v);
    }
    private void showPopuwindow(View v) {
        list = new ArrayList<>();
        Data data = new Data();
        data.setName("照片");
        Data data1 = new Data();
        data.setName("照片");
        Data data2 = new Data();
        data1.setName("视频");
        data2.setName("单品");
        list.add(data);
        list.add(data1);
        list.add(data2);
//        gridView.setAdapter(new MyBaseAdapter(this, list));
        View contentview = LayoutInflater.from(MainActivity.this).inflate(R.layout.pop_window, null);
        GridView gridView = (GridView) contentview.findViewById(R.id.gridview);
        gridView.setAdapter(new MyBaseAdapter(this, list));

        PopupWindow popupWindow = new PopupWindow(contentview, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.7f;
        getWindow().setAttributes(lp);

//        popupWindow.showAsDropDown(v);
        //获取自身的长宽高
        contentview.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        popupHeight = contentview.getMeasuredHeight();
        popupWidth = contentview.getMeasuredWidth();
        int[] location = new int[2];
        v.getLocationOnScreen(location);
        popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, (location[0]) - popupWidth / 2, location[1] - popupHeight);


    }
}
