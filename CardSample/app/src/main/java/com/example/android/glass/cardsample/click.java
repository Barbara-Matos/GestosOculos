package com.example.android.glass.cardsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class click extends AppCompatActivity {
    ImagesResponse imageResponse;
    TextView Nome;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.click);
        Intent intent = getIntent();
        Nome=findViewById(R.id.selectName);
        imageView=findViewById(R.id.selectedImage);


        if(intent.getExtras() != null){
            imageResponse= (ImagesResponse) intent.getSerializableExtra("data");
            Nome.setText(imageResponse.getIdmaquina());

            Glide.with(this).load(imageResponse.getImage()).into(imageView);

        }

    }
}