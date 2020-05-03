package com.example.retodeezer.model;

import java.io.Serializable;

public class Playlists implements Serializable {

    private PlayList[] data;
    private int total;
    private String next;

    public Playlists(){}

    public Playlists(PlayList[]data, int total, String next){


        this.data =data;
        this.total=total;
        this.next=next;
    }

    public PlayList[] getData() {
        return data;
    }

    public void setData(PlayList[] data) {
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

    public boolean isNext(){
        boolean c=false;

        if(next!= "" || next!=null){
            c=true;
        }

        return c;
    }


}
