package com.example.retodeezer.model;

import java.io.Serializable;

public class Track implements Serializable {

    private String id;
    private String title;
    private int duration;
    private Artist artist;
    private Album album;
    private String release_date;
    private String link;


    public Track(){}

    public Track(String id, String title,String link, int duration, String release_date, Album album, Artist artist ){

        this.id=id;
        this.title=title;
        this.duration=duration;
        this.link=link;
        this.album =album;
        this.artist =artist;
        this.release_date=release_date;


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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }



    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
