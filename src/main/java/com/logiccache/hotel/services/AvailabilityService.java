package com.logiccache.hotel.services;

import com.logiccache.hotel.domain.Availability;

import java.time.LocalDate;
import java.util.List;

public interface AvailabilityService {
    List<Availability> getAvailability(String roomId, LocalDate fromDate, LocalDate toDate);

    List<Availability> getAvailability(String roomId);
}
