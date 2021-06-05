package com.example.android.glass.cardsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.example.android.glass.cardsample.fragments.BaseFragment;
import com.example.android.glass.cardsample.fragments.InfoMaquinaLayoutFragment;
import com.example.android.glass.cardsample.fragments.MaquinaHistoricLayoutFragment;
import com.example.android.glass.cardsample.fragments.MaquinaOTAsLayoutFragment;
import com.example.android.glass.cardsample.fragments.VideosLayoutFragment;
import com.example.glass.ui.GlassGestureDetector;
import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ficheiros extends BaseActivity {

    private List<BaseFragment> fragments = new ArrayList<>();
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager_layout);

        final ficheiros.ScreenSlidePagerAdapter screenSlidePagerAdapter = new ficheiros.ScreenSlidePagerAdapter(
                getSupportFragmentManager());
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(screenSlidePagerAdapter);

        fragments.add(InfoMaquinaLayoutFragment.newInstance(null, null,null, null));
        fragments.add(VideosLayoutFragment.newInstance(null, null,null, null));

        screenSlidePagerAdapter.notifyDataSetChanged();

        final TabLayout tabLayout = findViewById(R.id.page_indicator);
        tabLayout.setupWithViewPager(viewPager, true);
    }

    @Override
    public boolean onGesture(GlassGestureDetector.Gesture gesture) {
        switch (gesture) {
            case TAP:
                if (viewPager.getCurrentItem()==0) {
                    //infoMaquina();
                }
                else {
                    //videos();
                }
                return true;
            //openUltimasManutencoes();
            case TWO_FINGER_TAP:
                if (viewPager.getCurrentItem()==0) {
                    goFotos();
                }
                else {
                    //pdf();
                }
                return true;
            case TWO_FINGER_SWIPE_BACKWARD:
                goBack();
                return true;
            default:
                return super.onGesture(gesture);
        }
    }

    public void goBack(){
        Intent intent=new Intent(this,MaquinaXXX.class);
        startActivity(intent);
    }

    public void goFotos(){
        Intent intent=new Intent(this,foto.class);
        startActivity(intent);
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

        ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public @NotNull Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}