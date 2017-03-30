package com.logiccache.hotel.repositories;

import com.logiccache.hotel.domain.Availability;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AvailabilityRepository extends MongoRepository<Availability, String>, AvailabilityRepositoryCustom {
    List<Availability> findByRoomId(String roomId);
}
