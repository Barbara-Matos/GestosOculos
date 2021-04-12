package com.example.android.glass.cardsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import android.content.Intent;
import android.os.Bundle;

import com.example.glass.ui.GlassGestureDetector;

public class ficheiros extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ficheiros);
    }

    @Override
    public boolean onGesture(GlassGestureDetector.Gesture gesture) {
        switch (gesture) {
           /* case TAP:

                return true;
                openUltimasManutencoes();
            case TWO_FINGER_TAP:

                return true;*/
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
}