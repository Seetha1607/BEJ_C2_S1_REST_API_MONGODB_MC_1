/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 24-11-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.example.service;

import com.example.domain.Track;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements ITrackService {
    @Override
    public Track saveTrackDetails(Track track) {
        return null;
    }

    @Override
    public List<Track> fetchAllTrack() {
        return null;
    }

    @Override
    public boolean deleteTrack(int trackId) {
        return false;
    }
}
