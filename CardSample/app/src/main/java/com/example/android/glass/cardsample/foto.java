package com.example.android.glass.cardsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.BaseBundle;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.example.glass.ui.GlassGestureDetector;

public class foto extends BaseActivity {
    GridView gridView;
    private List<ImagesResponse>imagesResponseList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foto);
        gridView = findViewById(R.id.gridView);
        getSupportActionBar().hide();
        getAllimages();
        //gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        // @Override
        // public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //     startActivity(new Intent(foto.this,click.class).putExtra("data",imagesResponseList.get(i)) );
        // }
        //}
        //);
    }

    @Override
    public boolean onGesture(GlassGestureDetector.Gesture gesture) {
        switch (gesture) {
            case TAP:
                click();
                return true;
            case TWO_FINGER_TAP:
                openPasso();
                return true;
            case TWO_FINGER_SWIPE_BACKWARD:
                goBack();
                return true;
            default:
                return super.onGesture(gesture);
        }
    }

    public void goBack(){
        Intent intent=new Intent(this,InfoMaquina.class);
        startActivity(intent);
    }

    public void click(){
        Intent intent=new Intent(this,click.class);
        startActivity(intent);
    }

    public void openPasso(){
        Intent intent=new Intent(this,Passo.class);
        startActivity(intent);
    }


    public void getAllimages(){
        Call<List<ImagesResponse>> imagesResponse = ApiClient.getinterface().getAllimages();
        imagesResponse.enqueue(new Callback<List<ImagesResponse>>() {
            @Override
            public void onResponse(Call<List<ImagesResponse>> call, Response<List<ImagesResponse>> response) {
                if(response.isSuccessful()){

                    imagesResponseList = response.body();

                    CustomAdapter customAdapter=new CustomAdapter(imagesResponseList,foto.this);
                    gridView.setAdapter(customAdapter);
                }else{

                }
            }

            @Override
            public void onFailure(Call<List<ImagesResponse>> call, Throwable t) {

            }
        });
    }

    public class CustomAdapter extends BaseAdapter{
        private List<ImagesResponse>imagesResponseList;
        private Context context;
        private LayoutInflater layoutInflater;

        public CustomAdapter(List<ImagesResponse> imagesResponseList, Context context) {
            this.imagesResponseList = imagesResponseList;
            this.context = context;
            this.layoutInflater= (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public int getCount() {
            return imagesResponseList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view == null){
                view=layoutInflater.inflate(R.layout.row_grid_items,viewGroup,false);

            }
            ImageView imageView=view.findViewById(R.id.imageView);
            TextView textView= view.findViewById(R.id.textView);
            textView.setText(imagesResponseList.get(i).getIdmaquina());

            Glide.with(context)
                    .load(imagesResponseList.get(i).getImage())
                    .into(imageView);

            return view;
        }
    }
}