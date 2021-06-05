package com.example.android.glass.cardsample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apinterface {

    @GET("fotos/")
    Call<List<ImagesResponse>> getAllimages();
}
