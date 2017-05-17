package com.logiccache.hotel.repositories;

import com.logiccache.hotel.domain.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookingRepository extends MongoRepository<Booking, String> {
    List<Booking> findByRoomId(String roomId);

    List<Booking> findByCustomerId(String customerId);

    List<Booking> findByRoomIdAndCustomerId(String roomId, String customerId);
}