package com.logiccache.hotel.services;

import com.logiccache.hotel.domain.Booking;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {
    List<Booking> getBookings();

    List<Booking> getBookings(String roomId, String customerId);

    List<Booking> getBookingsByRoom(String roomId);

    List<Booking> getBookingsByCustomer(String customerId);

    Booking createBooking(String roomId, String customerId, LocalDate fromDate, LocalDate toDate);
}
