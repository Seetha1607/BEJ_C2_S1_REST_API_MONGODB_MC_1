package com.example.repository;

import com.example.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends MongoRepository<Track, Integer> {
    @Query("{'track.trackRating':{$gt:[?0]}}")
    List<Track> findAllTrackByTrackRating(float trackRating);

    @Query("{'trackArtist.artistName':{$in:[?0]}}")
    List<Track> findByArtistName(String artistName);
}
