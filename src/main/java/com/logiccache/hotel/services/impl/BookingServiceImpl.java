package com.logiccache.hotel.services.impl;

import com.logiccache.hotel.domain.Booking;
import com.logiccache.hotel.repositories.BookingRepository;
import com.logiccache.hotel.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@Component("bookingService")
public class BookingServiceImpl implements BookingService {

    private final BookingRepository repository;

    @Autowired
    public BookingServiceImpl(BookingRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Booking> getBookings(String roomId, String customerId) {
        return repository.findAll();
    }

    @Override
    public Booking createBooking(String roomId, String customerId, LocalDate fromDate, LocalDate toDate) {
        return repository.save(Booking.builder().roomId(roomId).customerId(customerId).fromDate(fromDate).toDate(toDate).build());
    }
}
