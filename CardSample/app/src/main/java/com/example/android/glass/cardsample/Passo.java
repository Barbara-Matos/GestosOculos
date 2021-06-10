package com.example.android.glass.cardsample;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.example.android.glass.cardsample.fragments.BaseFragment;
import com.example.android.glass.cardsample.fragments.PassoAPassoFragment;
import com.example.glass.ui.GlassGestureDetector;
import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Passo extends BaseActivity {

    private List<BaseFragment> fragments = new ArrayList<>();
    private ViewPager viewPager;
    private List<ImagesResponse>imagesResponseList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager_layout);

        final Passo.ScreenSlidePagerAdapter screenSlidePagerAdapter = new Passo.ScreenSlidePagerAdapter(
                getSupportFragmentManager());
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(screenSlidePagerAdapter);
        getAllimages();
        fragments.add(PassoAPassoFragment.newInstance(imagesResponseList.get(1).getImage(), imagesResponseList.get(1).getInfo(),"Próximo Passo ->", null));

        screenSlidePagerAdapter.notifyDataSetChanged();

        final TabLayout tabLayout = findViewById(R.id.page_indicator);
        tabLayout.setupWithViewPager(viewPager, true);
    }

    @Override
    public boolean onGesture(GlassGestureDetector.Gesture gesture) {
        switch (gesture) {
            case TWO_FINGER_SWIPE_BACKWARD:
                goBack();
                return true;
            default:
                return super.onGesture(gesture);
        }
    }

    public void goBack(){
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

    public void getAllimages(){
        Call<List<ImagesResponse>> imagesResponse = ApiClient.getinterface().getAllimages();
        imagesResponse.enqueue(new Callback<List<ImagesResponse>>() {
            @Override
            public void onResponse(Call<List<ImagesResponse>> call, Response<List<ImagesResponse>> response) {
                if(response.isSuccessful()){
                    imagesResponseList = response.body();
                }
            }

            @Override
            public void onFailure(Call<List<ImagesResponse>> call, Throwable t) {

            }
        });
    }
}


/**

    public EditText passo1,info;
    GridView gridView;
    public int count = 1;
    public Button ProximoPasso;
    public String passo,infor;

    private List<ImagesResponse>imagesResponseList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passo);
        passo1 = findViewById(R.id.passo1);
        //info = findViewById(R.id.passo11);
        //gridView = findViewById(R.id.grid1);

        ProximoPasso = findViewById(R.id.butaoPasso);

        getSupportActionBar().hide();
        getAllimages();
    }
        @Override
        public boolean onGesture (GlassGestureDetector.Gesture gesture){
            switch (gesture) {
                case TAP:
                    getAllimages();
                    count = count + 1;
                    return true;
                case TWO_FINGER_TAP:
                    return true;
                case TWO_FINGER_SWIPE_BACKWARD:
                    goBack();
                    return true;
                default:
                    return super.onGesture(gesture);
            }
        }

    public void goBack(){
        Intent intent=new Intent(this,foto.class);
        startActivity(intent);
    }



    public class CustomAdapter extends BaseAdapter {
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

            passo="";
            infor="";
            passo=imagesResponseList.get(i).getPasso();
            infor=imagesResponseList.get(i).getInfo();

            if(passo.equals(String.valueOf(count))){

                passo1.setText("Passo "+ passo);
                info.setText(" " + infor );
                Glide.with(context)
                        .load(imagesResponseList.get(i).getImage())
                        .into(imageView);
            }

            return view;
        }
    }
}
**/