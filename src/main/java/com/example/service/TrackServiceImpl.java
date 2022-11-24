/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 24-11-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.example.service;

import com.example.domain.Track;
import com.example.exception.TrackExistsAlready;
import com.example.exception.TrackNotExists;
import com.example.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements ITrackService {

    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrackDetails(Track track) throws TrackExistsAlready {
        if (trackRepository.findById(track.getTrackId()).isPresent()) {
            throw new TrackExistsAlready();
        }
        return trackRepository.save(track);
    }

    @Override
    public List<Track> fetchAllTrack() {
        return trackRepository.findAll();
    }

    @Override
    public boolean deleteTrack(int trackId) throws TrackNotExists {
        if (trackRepository.findById(trackId).isEmpty()) {
            throw new TrackNotExists();
        }
        trackRepository.deleteById(trackId);
        return true;
    }

    @Override
    public List<Track> fetchTrackRatingGreaterThan(float trackRating) {
        return trackRepository.findAllTrackByTrackRating(trackRating);
    }

    @Override
    public List<Track> fetchTrackByArtistName(String artistName) {
        return trackRepository.findByArtistName(artistName);
    }
}
