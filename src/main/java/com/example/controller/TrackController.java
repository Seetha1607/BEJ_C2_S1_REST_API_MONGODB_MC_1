/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 24-11-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.example.controller;

import com.example.domain.Track;
import com.example.service.ITrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TrackController {
    private ITrackService iTrackService;

    @Autowired
    public TrackController(ITrackService iTrackService) {
        this.iTrackService = iTrackService;
    }

    @PostMapping("/insertTrackDetails")
    public ResponseEntity<?> saveTrackDetails(@RequestBody Track track) {
        return new ResponseEntity<>(iTrackService.saveTrackDetails(track), HttpStatus.CREATED);
    }

    @GetMapping("/fetchTrackDetails")
    public ResponseEntity<?> fetchTrackDetails() {
        return new ResponseEntity<>(iTrackService.fetchAllTrack(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteTrack/{trackId}")
    public ResponseEntity<?> deleteTrack(@PathVariable int trackId) {
        return new ResponseEntity<>(iTrackService.deleteTrack(trackId), HttpStatus.OK);
    }

    @GetMapping("/fetchTrackByTrackRatingGreaterThan/{trackRating}")
    public ResponseEntity<?> fetchTrackByTrackRatingGreaterThan(@PathVariable float trackRating) {
        return new ResponseEntity<>(iTrackService.fetchTrackRatingGreaterThan(trackRating), HttpStatus.OK);
    }

    @GetMapping("/fetchTrackByArtistName/{artistName}")
    public ResponseEntity<?> fetchTrackByArtistName(@PathVariable String artistName) {
        return new ResponseEntity<>(iTrackService.fetchTrackByArtistName(artistName), HttpStatus.ACCEPTED);
    }
}
