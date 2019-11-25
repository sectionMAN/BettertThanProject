package com.example.myapplication33;

import androidx.lifecycle.ViewModel;

public class MyModel extends ViewModel {
    private  byte[] photo;

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
