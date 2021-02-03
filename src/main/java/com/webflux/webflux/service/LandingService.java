package com.webflux.webflux.service;

import com.webflux.webflux.models.Landing;
import com.webflux.webflux.repo.LandingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.UUID;
import java.util.stream.IntStream;

@Service
public class LandingService {

    @Autowired
    private LandingRepository landingRepository;

    public Flux<Landing> getAllLandings(){
        return landingRepository.findAll();
    }

    public void insertAll() {
        IntStream.range(0, 1001).forEach(i -> {
            landingRepository.save(new Landing(UUID.randomUUID(), "Hi"+i, i, i * 1000)).subscribe(data -> {
               System.out.println(data.toString());
            });
        });
    }
}
