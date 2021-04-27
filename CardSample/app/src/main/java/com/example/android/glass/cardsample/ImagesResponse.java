package com.example.android.glass.cardsample;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ImagesResponse implements Serializable {

    private String idmaquina;
    private String image;

    public String getIdmaquina() {
        return idmaquina;
    }

    public void setIdmaquina(String idmaquina) {
        this.idmaquina = idmaquina;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
