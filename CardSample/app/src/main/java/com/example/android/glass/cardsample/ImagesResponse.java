package com.example.android.glass.cardsample;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ImagesResponse implements Serializable {

    private String idmaquina;
    private String image;

    private String info;
    private String passo;

    public String getInfo() {
        return info;
    }

    public void setInfor(String info) {
        this.info = info;
    }

    public String getPasso() {
        return passo;
    }

    public void setPasso(String passo) {
        this.passo = passo;
    }

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