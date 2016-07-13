package com.jt.icaew.android.activity;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewPager;

import com.jt.icaew.android.R;
import com.jt.icaew.android.activity.about.AboutFragment;
import com.jt.icaew.android.activity.contact.ContactFragment;
import com.jt.icaew.android.activity.events.EventsFragment;
import com.jt.icaew.android.activity.program.ProgramFragment;
import com.jt.icaew.android.activity.universities.UniversitiesFragment;
import com.jt.icaew.android.activity.view.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainView {
    @BindView(R.id.mainViewPager)
    ViewPager viewPager;

    @BindView(R.id.tab_main)
    TabLayout tab;

    /*@BindView(R.id.tab_main)
    TabLayout tabLayout;*/

    private MainPageAdapter adapter;
    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    public void onCreate() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        adapter = new MainPageAdapter
                (getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tab.setupWithViewPager(viewPager);
        setupTabIcons();
        //tabLayout.setupWithViewPager(viewPager);
    }

    protected class MainPageAdapter extends FragmentPagerAdapter {
        private final Fragment[] fragments;

        public MainPageAdapter(FragmentManager fm) {
            super(fm);
            this.fragments = new Fragment[]{
                    new ProgramFragment(),
                    new EventsFragment(),
                    new UniversitiesFragment(),
                    new AboutFragment(),
                    new ContactFragment()
            };
        }

        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }

        @Override
        public int getCount() {
            return fragments.length;
        }

        public int getIcon(final int position) {
            switch (position)
            {
                case 0:
                    return R.drawable.ic_student_cap;
                case 1:
                    return R.drawable.ic_event;
                case 2:
                    return R.drawable.ic_university;
                case 3:
                    return R.drawable.ic_about_us;
                case 4:
                    return R.drawable.ic_contact_us;
                default:
                    return R.drawable.ic_student_cap;
            }
        }
    }

    private void setupTabIcons() {
        tab.getTabAt(0).setIcon(getResources().getDrawable(adapter.getIcon(0)));
        tab.getTabAt(1).setIcon(getResources().getDrawable(adapter.getIcon(1)));
        tab.getTabAt(2).setIcon(getResources().getDrawable(adapter.getIcon(2)));
        tab.getTabAt(3).setIcon(getResources().getDrawable(adapter.getIcon(3)));
        tab.getTabAt(4).setIcon(getResources().getDrawable(adapter.getIcon(4)));

        //tab.getTabAt(0).getIcon().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);

        ColorStateList colors;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            colors = getResources().getColorStateList(R.color.selector_home_tab_icon, getTheme());
        }
        else {
            colors = getResources().getColorStateList(R.color.selector_home_tab_icon);
        }

        for (int i = 0; i < tab.getTabCount(); i++) {
            TabLayout.Tab t = tab.getTabAt(i);
            Drawable icon = t.getIcon();

            if (icon != null) {
                icon = DrawableCompat.wrap(icon);
                DrawableCompat.setTintList(icon, colors);
            }
        }

    }
}
