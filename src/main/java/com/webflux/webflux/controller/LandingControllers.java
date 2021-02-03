package com.webflux.webflux.controller;

import com.webflux.webflux.models.Landing;
import com.webflux.webflux.service.LandingService;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;


@RestController
public class LandingControllers {

    @Autowired
    private LandingService landingService;

    @GetMapping(value = "/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Publisher<Landing> getAllLandings() {
        Flux<Landing> data = landingService.getAllLandings().delayElements(Duration.ofSeconds(1));
        return data;
    }

    @GetMapping("/insert")
    public void insertAll() {
        System.out.println("hello from insert");
        landingService.insertAll();
    }

}
