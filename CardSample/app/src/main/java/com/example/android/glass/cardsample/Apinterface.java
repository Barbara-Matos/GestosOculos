package com.example.android.glass.cardsample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apinterface {

    @GET("informacao/")
    Call<List<ImagesResponse>> getAllimages();
}
