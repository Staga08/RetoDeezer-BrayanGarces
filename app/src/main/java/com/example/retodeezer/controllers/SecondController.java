package com.example.retodeezer.controllers;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.bumptech.glide.Glide;
import com.example.retodeezer.activities.ThirdActivity;
import com.example.retodeezer.model.PlayList;
import com.example.retodeezer.model.Track;
import com.example.retodeezer.model.TracksList;
import com.example.retodeezer.util.Constants;
import com.example.retodeezer.util.HTTPSWebUtilDomi;
import com.example.retodeezer.activities.SecondActivity;
import com.google.gson.Gson;


public class SecondController implements View.OnClickListener, HTTPSWebUtilDomi.OnResponseListener, AdapterView.OnItemClickListener {

    private SecondActivity activity;
    private HTTPSWebUtilDomi utilDomi;
    private PlayList playlists;
    private TracksList tracklist;
    private Intent intent;


    public SecondController(SecondActivity activity){
        this.activity=activity;
        utilDomi= new HTTPSWebUtilDomi();
        utilDomi.setListener(this);

        tracklist= (TracksList) activity.getIntent().getExtras().get("tracks");
        playlists=(PlayList) activity.getIntent().getExtras().get("playStats");



        //Log.e("", ""+playlists.getTitle());

        activity.getTracklistName().setText(playlists.getTitle());
        activity.getTracklistDesc().setText(playlists.getDescription());
        activity.getTracklistFans().setText(playlists.getFans()+" Fans");
        activity.getTracklistNb().setText(playlists.getNb_tracks()+" Canciones");
        Glide.with(activity).load(playlists.getPicture_medium()).centerCrop().into(activity.getTracklistPhoto());


        for (int i=0; i<tracklist.getData().length; i++){
            int item=i;
            new Thread(
                    ()->{

                        utilDomi.GETrequest(Constants.TRACKLISTS_TAP, "https://api.deezer.com/track/"+tracklist.getData()[item].getId());

                    }

            ).start();
        }


    }

    @Override
    public void onClick(View v) {
        //Toast.makeText(activity, "funciona!!",Toast.LENGTH_SHORT).show();
         intent= new Intent(activity, ThirdActivity.class);
        //Log.e("",""+activity.getmAdapter().getTracks().get(activity.getMy_recycler_view().getChildAdapterPosition(v)));
         intent.putExtra("theTrack", activity.getmAdapter().getTracks().get(activity.getMy_recycler_view().getChildAdapterPosition(v)));
         activity.startActivity(intent);


    }

    @Override
    public void onResponse(int callbackID, String response) {
        switch (callbackID){

            case Constants.TRACKLISTS_TAP:
                Gson gson= new Gson();
                Track track= gson.fromJson(response, Track.class);

                activity.runOnUiThread(
                        ()->{
                            activity.getmAdapter().getTracks().add(track);
                            activity.getmAdapter().notifyDataSetChanged();
                        }
                );
        }


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }



}
