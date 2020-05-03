package com.example.retodeezer.controllers;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.retodeezer.R;
import com.example.retodeezer.activities.ThirdActivity;
import com.example.retodeezer.model.Track;
import com.example.retodeezer.util.Constants;

import java.util.List;

public class ThirdController implements View.OnClickListener{

    private ThirdActivity activity;
    private Track track;
    public ThirdController(ThirdActivity activity){
        this.activity=activity;

        activity.getListenBtn().setOnClickListener(this);
        track= (Track) activity.getIntent().getExtras().get("theTrack");

        //Log.e("", ""+track);

        activity.runOnUiThread(
                ()->{

                    activity.getTrackArtist().setText(track.getArtist().getName());
                    Log.e("",""+track.getDuration());

                    int duration=track.getDuration();
                    int min=duration/60;
                    int seg=(duration-(min*60));


                    activity.getTrackDuration().setText(""+min+":"+seg);
                    activity.getTrackName().setText(track.getTitle());
                    Glide.with(activity).load(track.getAlbum().getCover_medium()).into(activity.getTrackPhoto());


                }
        );
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.listenBtn:
                String search=track.getLink();
                Log.e("", ""+search);

                new Thread(() -> {

                    Uri webpage = Uri.parse(search);

                    Intent webIntent = new Intent(Intent.ACTION_VIEW,webpage);


                    PackageManager packageManager= activity.getPackageManager();
                    List<ResolveInfo> activities = packageManager.queryIntentActivities(webIntent,0);
                    boolean isIntentSafe= activities.size()>0;


                    if (isIntentSafe){
                        activity.startActivity(webIntent);
                    }


                }).start();
                break;

        }
    }




}
