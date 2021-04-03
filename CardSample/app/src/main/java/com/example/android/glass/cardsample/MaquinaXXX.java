package com.example.android.glass.cardsample;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.android.glass.cardsample.fragments.BaseFragment;
import com.example.android.glass.cardsample.fragments.ColumnLayoutFragment;
import com.example.android.glass.cardsample.fragments.MainLayoutFragment;
import com.example.android.glass.cardsample.fragments.MaquinaHistoricLayoutFragment;
import com.example.android.glass.cardsample.fragments.MaquinaOTAsLayoutFragment;
import com.example.glass.ui.GlassGestureDetector;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MaquinaXXX extends BaseActivity{

    private List<BaseFragment> fragments = new ArrayList<>();
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager_layout);

        final MaquinaXXX.ScreenSlidePagerAdapter screenSlidePagerAdapter = new MaquinaXXX.ScreenSlidePagerAdapter(
                getSupportFragmentManager());
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(screenSlidePagerAdapter);

        fragments.add(MaquinaOTAsLayoutFragment.newInstance(null, null,null, null));
        fragments.add(MaquinaHistoricLayoutFragment.newInstance(null, null,null, null));

        screenSlidePagerAdapter.notifyDataSetChanged();

        final TabLayout tabLayout = findViewById(R.id.page_indicator);
        tabLayout.setupWithViewPager(viewPager, true);
    }

    @Override
    public boolean onGesture(GlassGestureDetector.Gesture gesture) {
        switch (gesture) {
            case SWIPE_FORWARD:
                fragments.get(viewPager.getCurrentItem()).onSingleTapUp();
                return true;
           /* case TAP:
                openOTAs();
                return true;
            case TWO_FINGER_TAP:
                openFiles();
                return true;*/
            case TWO_FINGER_SWIPE_BACKWARD:
                goBack();
                return true;
            default:
                return super.onGesture(gesture);
        }
    }

  /*  public void openOTAs() {
        Intent intent = new Intent(this, .class);
        startActivity(intent);
    }
    public void openFiles() {
        Intent intent = new Intent(this, .class);
        startActivity(intent);
    }
*/
    public void goBack(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

        ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}