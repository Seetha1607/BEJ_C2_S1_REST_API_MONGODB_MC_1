package com.example.service;

import com.example.domain.Track;

import java.util.List;

public interface ITrackService {
    public Track saveTrackDetails(Track track);

    public List<Track> fetchAllTrack();

    public boolean deleteTrack(int trackId);
}
