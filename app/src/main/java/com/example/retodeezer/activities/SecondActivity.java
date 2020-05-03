package com.example.retodeezer.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retodeezer.R;
import com.example.retodeezer.adapters.TracklistAdapter;
import com.example.retodeezer.controllers.SecondController;

public class SecondActivity extends AppCompatActivity {
    private ImageView tracklistPhoto;
    private TextView tracklistName;
    private TextView tracklistDesc;
    private TextView tracklistNb;
    private TextView tracklistFans;
    private RecyclerView my_recycler_view;
    private RecyclerView.LayoutManager layoutManager;
    private TracklistAdapter mAdapter;
    private SecondController controller;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tracklistPhoto= findViewById(R.id.tracklistPhoto);
        tracklistName= findViewById(R.id.tracklistName);
        tracklistDesc= findViewById(R.id.tracklistDesc);
        tracklistNb= findViewById(R.id.tracklistNb);
        tracklistFans= findViewById(R.id.tracklistFans);
        my_recycler_view= findViewById(R.id.my_recycler_view);

       // my_recycler_view.setHasFixedSize(true);

        layoutManager= new LinearLayoutManager(this);
        my_recycler_view.setLayoutManager(layoutManager);

        mAdapter= new TracklistAdapter(this);


        my_recycler_view.setAdapter(mAdapter);


        controller= new SecondController(this);
        mAdapter.setOnClickListener(controller);



    }

    public ImageView getTracklistPhoto() {
        return tracklistPhoto;
    }

    public void setTracklistPhoto(ImageView tracklistPhoto) {
        this.tracklistPhoto = tracklistPhoto;
    }

    public TextView getTracklistName() {
        return tracklistName;
    }

    public void setTracklistName(TextView tracklistName) {
        this.tracklistName = tracklistName;
    }

    public TextView getTracklistDesc() {
        return tracklistDesc;
    }

    public void setTracklistDesc(TextView tracklistDesc) {
        this.tracklistDesc = tracklistDesc;
    }

    public TextView getTracklistNb() {
        return tracklistNb;
    }

    public void setTracklistNb(TextView tracklistNb) {
        this.tracklistNb = tracklistNb;
    }

    public TextView getTracklistFans() {
        return tracklistFans;
    }

    public void setTracklistFans(TextView tracklistFans) {
        this.tracklistFans = tracklistFans;
    }

    public RecyclerView getMy_recycler_view() {
        return my_recycler_view;
    }

    public void setMy_recycler_view(RecyclerView my_recycler_view) {
        this.my_recycler_view = my_recycler_view;
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return layoutManager;
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    public TracklistAdapter getmAdapter() {
        return mAdapter;
    }

    public void setmAdapter(TracklistAdapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    public SecondController getController() {
        return controller;
    }

    public void setController(SecondController controller) {
        this.controller = controller;
    }
}
