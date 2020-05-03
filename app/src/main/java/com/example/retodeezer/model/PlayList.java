package com.example.retodeezer.model;

import java.io.Serializable;

public class PlayList implements Serializable {
    private String id;
    private String title;
    private int nb_tracks;
    private String picture;
    private String picture_small;
    private String picture_medium;
    private User user;
    private String tracklist;
    private int fans;
    private String description;

    public PlayList(){}

    public PlayList(String id, String title,String description, int nb_tracks,int fans, String picture,
                    String picture_small, String picture_medium, User user, String tracklist){
    this.id=id;
    this.description=description;
    this.fans=fans;
    this.title=title;
    this.nb_tracks=nb_tracks;
    this.picture=picture;
    this.picture_small=picture_small;
    this.picture_medium=picture_medium;
    this.user=user;
    this.tracklist=tracklist;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNb_tracks() {
        return nb_tracks;
    }

    public void setNb_tracks(int nb_tracks) {
        this.nb_tracks = nb_tracks;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPicture_small() {
        return picture_small;
    }

    public void setPicture_small(String picture_small) {
        this.picture_small = picture_small;
    }

    public String getPicture_medium() {
        return picture_medium;
    }

    public void setPicture_medium(String picture_medium) {
        this.picture_medium = picture_medium;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User creator) {
        this.user = user;
    }

    public String getTracklist() {
        return tracklist;
    }

    public void setTracklist(String tracklist) {
        this.tracklist = tracklist;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
