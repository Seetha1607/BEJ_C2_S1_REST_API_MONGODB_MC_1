/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 25-11-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Track with Specific code doesn't Exists. Try some other code!")
public class TrackNotExists extends Exception {
}
