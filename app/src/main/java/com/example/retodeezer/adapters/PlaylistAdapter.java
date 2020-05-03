package com.example.retodeezer.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.retodeezer.R;
import com.example.retodeezer.activities.MainActivity;
import com.example.retodeezer.model.PlayList;
import java.util.ArrayList;

public class PlaylistAdapter extends BaseAdapter {
    private ArrayList<PlayList> playArray;
    private MainActivity activity;

    public PlaylistAdapter(MainActivity activity){
        this.activity=activity;
        playArray= new ArrayList<>();
    }
    @Override
    public int getCount() {
        return playArray.size();
    }

    @Override
    public Object getItem(int position) {
        return playArray.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        View row=inflater.inflate(R.layout.playlist_row, null, false );
        ImageView playlistPhoto = row.findViewById(R.id.playlistPhoto);
        TextView playlistName = row.findViewById(R.id.playlistName);
        TextView playlistCreator = row.findViewById(R.id.playlistCreator);
        TextView playlistItem = row.findViewById(R.id.playlistItems);

        Glide.with(activity).load(playArray.get(pos).getPicture_medium()).centerCrop().into(playlistPhoto);

        playlistName.setText( playArray.get(pos).getTitle());
        playlistCreator.setText( playArray.get(pos).getUser().getName());
        playlistItem.setText( playArray.get(pos).getNb_tracks()+"");

        return row;
    }


    public ArrayList<PlayList> getPlaylists() {
        return playArray;
    }

    public void setPlaylists(ArrayList<PlayList> playArray) {
        this.playArray = playArray;
    }
}
