package com.example.retodeezer.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.retodeezer.R;
import com.example.retodeezer.activities.SecondActivity;
import com.example.retodeezer.model.Track;

import java.util.ArrayList;

public class TracklistAdapter extends RecyclerView.Adapter<TracklistAdapter.MyViewHolder> implements View.OnClickListener{

    private SecondActivity activity;
    private ArrayList<Track> tracks;
    private View.OnClickListener listener;

    public TracklistAdapter(SecondActivity activity){
        this.activity=activity;

        tracks=new ArrayList<>();
    }

    public SecondActivity getActivity() {
        return activity;
    }

    public void setActivity(SecondActivity activity) {
        this.activity = activity;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public void setTracks(ArrayList<Track> tracks) {
        this.tracks = tracks;
    }

    public View.OnClickListener getListener() {
        return listener;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public TracklistAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.tracks_row,null,false);
        v.setOnClickListener(this);
        MyViewHolder vh=new MyViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull TracklistAdapter.MyViewHolder holder, int position) {
        //Log.e("", ""+ tracks.get(position).getAlbum());

        holder.trackName.setText(tracks.get(position).getTitle());
        holder.trackArtist.setText(tracks.get(position).getArtist().getName());
        holder.trackDate.setText(tracks.get(position).getRelease_date());
        Glide.with(activity).load(tracks.get(position).getAlbum().getCover_medium()).centerCrop().into(holder.trackPhoto);
    }

    @Override
    public int getItemCount() {
        return tracks.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;

    }
    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }


    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView trackName;
        public TextView trackArtist;
        public TextView trackDate;
        public ImageView trackPhoto;
        public MyViewHolder(View itemView) {
            super(itemView);

            trackPhoto= itemView.findViewById(R.id.trackPhoto);
            trackName=itemView.findViewById(R.id.trackName);
            trackArtist=itemView.findViewById(R.id.trackArtist);
            trackDate=itemView.findViewById(R.id.trackDate);

        }
    }



}
