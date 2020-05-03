package com.example.retodeezer.model;

import java.io.Serializable;

public class TracksList implements Serializable {

    private Track[] data;
    private int total;
    private String next;


    public TracksList(){}

    public TracksList(Track[]tracks, int total, String next){


        this.data =tracks;
        this.total=total;
        this.next=next;
    }

    public Track[] getData() {
        return data;
    }

    public void setData(Track[] data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }


}
