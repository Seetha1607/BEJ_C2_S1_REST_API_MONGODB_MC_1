/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 24-11-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.example.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.StringJoiner;

@Document
public class Track {
    @Id
    private int trackId;
    private String trackName;
    private float trackRating;
    private Track trackArtist;

    public Track() {
    }

    public Track(int trackId, String trackName, float trackRating, Track trackArtist) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.trackRating = trackRating;
        this.trackArtist = trackArtist;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public float getTrackRating() {
        return trackRating;
    }

    public void setTrackRating(float trackRating) {
        this.trackRating = trackRating;
    }

    public Track getTrackArtist() {
        return trackArtist;
    }

    public void setTrackArtist(Track trackArtist) {
        this.trackArtist = trackArtist;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Track.class.getSimpleName() + "[", "]")
                .add("trackId=" + trackId)
                .add("trackName='" + trackName + "'")
                .add("trackRating=" + trackRating)
                .add("trackArtist=" + trackArtist)
                .toString();
    }
}
