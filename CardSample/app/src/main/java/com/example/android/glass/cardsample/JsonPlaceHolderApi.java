package com.example.android.glass.cardsample;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface JsonPlaceHolderApi {

    // @GET("historico/")
    //Call<List<Post>> getPosts();
    @GET("/historico/get/{id}/")
    Call<PostList> getPosts(@Path("id") String id);
    //@GET("historico/")
    //Call<List<Post>> getPosts(@QueryMap Map<String,String> parameters);
}
