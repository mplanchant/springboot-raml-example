package com.logiccache.hotel.repositories;

import com.logiccache.hotel.domain.Availability;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AvailabilityRepository extends MongoRepository<Availability, String> {
}
