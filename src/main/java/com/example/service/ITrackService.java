package com.example.service;

import com.example.domain.Track;
import com.example.exception.TrackExistsAlready;
import com.example.exception.TrackNotExists;

import java.util.List;

public interface ITrackService {
    public Track saveTrackDetails(Track track) throws TrackExistsAlready;

    public List<Track> fetchAllTrack();

    public boolean deleteTrack(int trackId) throws TrackNotExists;

    public List<Track> fetchTrackRatingGreaterThan(float trackRating);

    public List<Track> fetchTrackByArtistName(String artistName);

}
