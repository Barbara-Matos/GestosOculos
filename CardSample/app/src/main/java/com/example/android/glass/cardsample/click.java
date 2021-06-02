package com.example.android.glass.cardsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.glass.ui.GlassGestureDetector;

public class click extends BaseActivity {
    ImagesResponse imageResponse;
    TextView Nome;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.click);
        Intent intent = getIntent();
        imageView=findViewById(R.id.selectedImage);


        if(intent.getExtras() != null){
            imageResponse= (ImagesResponse) intent.getSerializableExtra("data");
            Nome.setText(imageResponse.getIdmaquina());
            String idmaquina=imageResponse.getIdmaquina();
            if(idmaquina.equals("392098")) {
                Glide.with(this)
                        .load(imageResponse.getImage())
                        .into(imageView);
            }
        }
    }

    @Override
    public boolean onGesture (GlassGestureDetector.Gesture gesture){
        switch (gesture) {
            case TAP:
                return true;
            case TWO_FINGER_TAP:
                return true;
            case TWO_FINGER_SWIPE_BACKWARD:
                goBack();
            default:
                return super.onGesture(gesture);
        }
    }

    public void goBack(){
        Intent intent=new Intent(this,foto.class);
        startActivity(intent);
    }
}