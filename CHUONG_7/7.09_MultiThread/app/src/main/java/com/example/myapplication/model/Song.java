package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class Song {
    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("album")
    private String album;

    @SerializedName("artist")
    private String artist;

    @SerializedName("source")
    private String source;

    @SerializedName("image")
    private String image;

    @SerializedName("duration")
    private Long duration;

    public Song() {}
    public Song(String id, String title, String album,
                String artist, String source, String image, Long duration) {
        this.id = id;
        this.title = title;
        this.album = album;
        this.artist = artist;
        this.source = source;
        this.image = image;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    @SuppressWarnings("unused")
    public void setId(String id) {
        this.id = id;
    }

    @SuppressWarnings("unused")
    public String getTitle() {
        return title;
    }

    @SuppressWarnings("unused")
    public void setTitle(String title) {
        this.title = title;
    }

    @SuppressWarnings("unused")
    public String getAlbum() {
        return album;
    }

    @SuppressWarnings("unused")
    public void setAlbum(String album) {
        this.album = album;
    }

    @SuppressWarnings("unused")
    public String getArtist() {
        return artist;
    }

    @SuppressWarnings("unused")
    public void setArtist(String artist) {
        this.artist = artist;
    }

    @SuppressWarnings("unused")
    public String getSource() {
        return source;
    }

    @SuppressWarnings("unused")
    public void setSource(String source) {
        this.source = source;
    }

    @SuppressWarnings("unused")
    public String getImage() {
        return image;
    }

    @SuppressWarnings("unused")
    public void setImage(String image) {
        this.image = image;
    }

    @SuppressWarnings("unused")
    public Long getDuration() {
        return duration;
    }

    @SuppressWarnings("unused")
    public void setDuration(Long duration) {
        this.duration = duration;
    }
}
