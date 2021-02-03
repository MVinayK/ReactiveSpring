package com.webflux.webflux.repo;

import com.webflux.webflux.models.Landing;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LandingRepository extends ReactiveMongoRepository<Landing, UUID> {
}
