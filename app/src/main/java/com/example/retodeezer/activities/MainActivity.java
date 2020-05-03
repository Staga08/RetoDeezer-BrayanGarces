package com.example.retodeezer.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.retodeezer.adapters.PlaylistAdapter;
import com.example.retodeezer.R;
import com.example.retodeezer.controllers.MainController;

public class MainActivity extends AppCompatActivity {

    private ListView playlistView;
    private EditText searchPlay;
    private ImageButton searchBtn;
    private PlaylistAdapter adapter;
    private MainController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playlistView =findViewById(R.id.playlistView);
        searchPlay= findViewById(R.id.searchPlay);
        searchBtn=findViewById(R.id.searchBtn);
        adapter=new PlaylistAdapter(this);
        playlistView.setAdapter(adapter);

        controller=new MainController(this);
    }

    public ListView getPlaylistView() {
        return playlistView;
    }

    public EditText getSearchPlay() {
        return searchPlay;
    }

    public ImageButton getSearchBtn() {
        return searchBtn;
    }

    public PlaylistAdapter getAdapter() {
        return adapter;
    }

    public MainController getController() {
        return controller;
    }
}
