package com.logiccache.hotel.services.impl;

import com.logiccache.hotel.domain.Booking;
import com.logiccache.hotel.repositories.BookingRepository;
import com.logiccache.hotel.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service("bookingService")
public class BookingServiceImpl implements BookingService {

    private final BookingRepository repository;

    @Autowired
    public BookingServiceImpl(BookingRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Booking> getBookings() {
        return repository.findAll();
    }

    @Override
    public List<Booking> getBookings(String roomId, String customerId) {
        return repository.findByRoomIdAndCustomerId(roomId, customerId);
    }

    @Override
    public List<Booking> getBookingsByRoom(String roomId) {
        return repository.findByRoomId(roomId);
    }

    @Override
    public List<Booking> getBookingsByCustomer(String customerId) {
        return repository.findByCustomerId(customerId);
    }

    @Override
    public Booking createBooking(String roomId, String customerId, LocalDate fromDate, LocalDate toDate) {
        return repository.save(Booking.builder().roomId(roomId).customerId(customerId).fromDate(fromDate).toDate(toDate).build());
    }
}
