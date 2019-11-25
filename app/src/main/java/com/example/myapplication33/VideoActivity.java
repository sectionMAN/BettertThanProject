package com.example.myapplication33;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.TextView;

public class VideoActivity extends AppCompatActivity {
    MyModel model;
    byte[] photo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        model = ViewModelProviders.of(this).get(MyModel.class);
        photo = model.getPhoto();
        DatabaseAccess dba = DatabaseAccess.getInstance(this);
        dba.open();
        String vname = dba.getVideoName(photo);
        TextView pole = findViewById(R.id.pole);
        pole.setText(vname) ;
    }
}
