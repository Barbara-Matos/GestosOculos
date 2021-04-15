package com.example.android.glass.cardsample;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.android.glass.cardsample.fragments.BaseFragment;
import com.example.android.glass.cardsample.fragments.ListOTAsLayoutFragment;
import com.example.android.glass.cardsample.fragments.MaquinaHistoricLayoutFragment;
import com.example.android.glass.cardsample.fragments.MaquinaOTAsLayoutFragment;
import com.example.android.glass.cardsample.fragments.UltimasManutencoesLayoutFragment;
import com.example.glass.ui.GlassGestureDetector;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class otas extends BaseActivity{

    private List<BaseFragment> fragments = new ArrayList<>();
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager_layout);

        final otas.ScreenSlidePagerAdapter screenSlidePagerAdapter = new otas.ScreenSlidePagerAdapter(
                getSupportFragmentManager());
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(screenSlidePagerAdapter);

        fragments.add(ListOTAsLayoutFragment.newInstance(null, null,null, null));
        fragments.add(UltimasManutencoesLayoutFragment.newInstance(null, null,null, null));

        screenSlidePagerAdapter.notifyDataSetChanged();

        final TabLayout tabLayout = findViewById(R.id.page_indicator);
        tabLayout.setupWithViewPager(viewPager, true);
    }

    @Override
    public boolean onGesture(GlassGestureDetector.Gesture gesture) {
        switch (gesture) {
            case TAP:
                if (viewPager.getCurrentItem()==0) {
                   // openOTAspecs();
                }
                else {
                    openUltimasManutencoes();
                }
                return true;
            case TWO_FINGER_TAP:
                if (viewPager.getCurrentItem()==0) {
                    return super.onGesture(gesture);
                }
                else {
                    criarNovaOTA();
                }
                return true;
            case TWO_FINGER_SWIPE_BACKWARD:
                goBack();
                return true;
            default:
                return super.onGesture(gesture);
        }
    }

   /* public void openOTAspecs() {
        Intent intent = new Intent(this, .class);
         startActivity(intent);
    } */

    public void openUltimasManutencoes() {
        Intent intent = new Intent(this, UltimasManutencoes.class);
        startActivity(intent);
    }

    public void criarNovaOTA() {
        Intent intent = new Intent(this, NovaOTA.class);
        startActivity(intent);
    }

    public void goBack(){
        Intent intent=new Intent(this,MaquinaXXX.class);
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
