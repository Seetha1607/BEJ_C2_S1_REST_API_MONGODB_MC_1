/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 24-11-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.example.controller;

import com.example.service.ITrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TrackController {
    private ITrackService iTrackService;

    @Autowired
    public TrackController(ITrackService iTrackService) {
        this.iTrackService = iTrackService;
    }
}
