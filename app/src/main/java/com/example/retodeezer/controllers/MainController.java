package com.example.retodeezer.controllers;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.example.retodeezer.activities.MainActivity;
import com.example.retodeezer.R;
import com.example.retodeezer.model.PlayList;
import com.example.retodeezer.model.Playlists;
import com.example.retodeezer.model.TracksList;
import com.example.retodeezer.util.Constants;
import com.example.retodeezer.util.HTTPSWebUtilDomi;
import com.example.retodeezer.activities.SecondActivity;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collections;


public class MainController implements View.OnClickListener, HTTPSWebUtilDomi.OnResponseListener, AdapterView.OnItemClickListener {

    private MainActivity activity;
    private HTTPSWebUtilDomi utilDomi;
    private Playlists playlists;
    private PlayList sendPacket;
    private TracksList tracklist;
    private Intent i;
    private int item;

    public MainController(MainActivity activity){
        this.activity=activity;
        activity.getSearchBtn().setOnClickListener(this);
        utilDomi= new HTTPSWebUtilDomi();
        utilDomi.setListener(this);

        activity.getPlaylistView().setOnItemClickListener(this);

        i= new Intent(activity, SecondActivity.class);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.searchBtn:
                String search=activity.getSearchPlay().getText().toString().replace(" ", "");

                new Thread(() -> {

                    utilDomi.GETrequest(Constants.SEARCH_CALLBACK, "https://api.deezer.com/search/playlist?q=" + search);

                }).start();
                break;

        }





    }

    @Override
    public void onResponse(int callbackID, String response) {
        //Log.e("", ""+callbackID );
        switch (callbackID){

            case Constants.SEARCH_CALLBACK:
                Gson gson = new Gson();

                playlists=gson.fromJson(response, Playlists.class);

                ArrayList<PlayList> playListss= new ArrayList<>();
                Collections.addAll(playListss, playlists.getData());

                activity.runOnUiThread(
                        ()->{
                            //Log.e("", ""+playListss.get(0).getNb_tracks());
                            activity.getAdapter().setPlaylists(playListss);
                            activity.getAdapter().notifyDataSetChanged();
                        });

                break;

            case Constants.LISTINFO:

                Gson gson2 = new Gson();
                sendPacket=gson2.fromJson(response, PlayList.class);

                break;

            case Constants.TRACKLISTS_TAP:
                Gson gson1= new Gson();
                tracklist= gson1.fromJson(response, TracksList.class);


                i.putExtra("tracks", tracklist);
                //Log.e("", ""+sendPacket.getTitle());

                i.putExtra("playStats",sendPacket );
                activity.startActivity(i);




                break;



        }


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        new Thread(
                ()->{
                    utilDomi.GETrequest(Constants.LISTINFO, "https://api.deezer.com/playlist/" + activity.getAdapter().getPlaylists().get(position).getId());
                    //item=position;
                  utilDomi.GETrequest(Constants.TRACKLISTS_TAP, activity.getAdapter().getPlaylists().get(position).getTracklist());
                }
        ).start();
    }
}
