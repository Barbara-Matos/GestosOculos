package com.example.android.glass.cardsample;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.gesture.Gesture;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.android.glass.cardsample.R;
import com.example.glass.ui.GlassGestureDetector;

public class qrcode extends AppCompatActivity {
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        getSupportActionBar().hide();
        button1=findViewById(R.id.ot);
    }

    public void open1(){
        Intent intent=new Intent(this,ordem_trabalho.class);
        startActivity(intent);
    }
}