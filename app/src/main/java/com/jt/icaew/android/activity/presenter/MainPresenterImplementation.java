package com.jt.icaew.android.activity.presenter;

import android.support.v4.app.FragmentPagerAdapter;

import com.jt.icaew.android.activity.MainModel;
import com.jt.icaew.android.activity.view.MainView;

/**
 * Created by Wandy on 6/30/2016.
 */
public class MainPresenterImplementation implements MainPresenter {
    MainView mainView;

    public MainPresenterImplementation(MainView mainView)
    {
        this.mainView = mainView;
    }

    @Override
    public void setupViewPager(FragmentPagerAdapter fragmentPagerAdapter) {
    }
}
