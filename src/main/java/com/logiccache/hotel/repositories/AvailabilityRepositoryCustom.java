package com.logiccache.hotel.repositories;

import com.logiccache.hotel.domain.Availability;

import java.time.LocalDate;
import java.util.List;

public interface AvailabilityRepositoryCustom {
    List<Availability> findByRoomIdAndDateAfterAndDateBefore(String roomId, LocalDate fromDate, LocalDate toDate);
}