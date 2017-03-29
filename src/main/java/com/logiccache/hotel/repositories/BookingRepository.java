package com.logiccache.hotel.repositories;

import com.logiccache.hotel.domain.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking, String> {
}