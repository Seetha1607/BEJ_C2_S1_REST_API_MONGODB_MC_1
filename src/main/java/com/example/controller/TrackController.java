/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 24-11-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.example.controller;

import com.example.domain.Track;
import com.example.exception.TrackExistsAlready;
import com.example.exception.TrackNotExists;
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
    public ResponseEntity<?> saveTrackDetails(@RequestBody Track track) throws TrackExistsAlready {
        try {
            return new ResponseEntity<>(iTrackService.saveTrackDetails(track), HttpStatus.CREATED);
        } catch (TrackExistsAlready e) {
            throw new TrackExistsAlready();
        } catch (Exception e) {
            return new ResponseEntity<>("Server Error!!!try after Sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fetchTrackDetails")
    public ResponseEntity<?> fetchTrackDetails() {
        return new ResponseEntity<>(iTrackService.fetchAllTrack(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteTrack/{trackId}")
    public ResponseEntity<?> deleteTrack(@PathVariable int trackId) throws TrackNotExists {
        try {
            return new ResponseEntity<>(iTrackService.deleteTrack(trackId), HttpStatus.OK);
        } catch (TrackNotExists e) {
            throw new TrackNotExists();
        } catch (Exception e) {
            return new ResponseEntity<>("Server Error!!!try after Sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
