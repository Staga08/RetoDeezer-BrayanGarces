package com.example.retodeezer.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.retodeezer.R;
import com.example.retodeezer.controllers.ThirdController;

public class ThirdActivity extends AppCompatActivity {

    private ImageView trackPhoto;
    private TextView trackArtist;
    private TextView trackDuration;
    private TextView trackName;
    private Button listenBtn;
    private ThirdController controller;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        trackName=findViewById(R.id.trackName);
        trackPhoto= findViewById(R.id.trackPhoto);
        trackArtist=findViewById(R.id.trackArtist);
        trackDuration=findViewById(R.id.trackDuration);
        listenBtn=findViewById(R.id.listenBtn);

        controller= new ThirdController(this);

    }

    public TextView getTrackName() {
        return trackName;
    }

    public void setTrackName(TextView trackName) {
        this.trackName = trackName;
    }

    public ImageView getTrackPhoto() {
        return trackPhoto;
    }

    public void setTrackPhoto(ImageView trackPhoto) {
        this.trackPhoto = trackPhoto;
    }

    public TextView getTrackArtist() {
        return trackArtist;
    }

    public void setTrackArtist(TextView trackArtist) {
        this.trackArtist = trackArtist;
    }

    public TextView getTrackDuration() {
        return trackDuration;
    }

    public void setTrackDuration(TextView trackDuration) {
        this.trackDuration = trackDuration;
    }

    public Button getListenBtn() {
        return listenBtn;
    }

    public void setListenBtn(Button listenBtn) {
        this.listenBtn = listenBtn;
    }

    public ThirdController getController() {
        return controller;
    }

    public void setController(ThirdController controller) {
        this.controller = controller;
    }
}
