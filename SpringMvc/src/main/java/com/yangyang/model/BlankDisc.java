package com.yangyang.model;

import org.springframework.stereotype.Component;

@Component
public class BlankDisc {
    private String title;
    private String artlist;

    public BlankDisc() {
    }

    public BlankDisc( String title,String artlist) {
        this.title = title;
        this.artlist = artlist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtlist() {
        return artlist;
    }

    public void setArtlist(String artlist) {
        this.artlist = artlist;
    }

    @Override
    public String toString() {
        return "BlankDisc{" +
                "title='" + title + '\'' +
                ", artlist='" + artlist + '\'' +
                '}';
    }
}
