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
        Booking booking1 = Booking.builder().roomId("001").customerId("100").fromDate(LocalDate.of(2017, Month.APRIL, 1)).toDate(LocalDate.of(2017, Month.APRIL, 10)).build();
        Booking booking2 = Booking.builder().roomId("001").customerId("200").fromDate(LocalDate.of(2017, Month.MAY, 12)).toDate(LocalDate.of(2017, Month.MAY, 15)).build();
        return Arrays.asList(booking1, booking2);
    }

    @Override
    public Booking createBooking(String roomId, String customerId, LocalDate fromDate, LocalDate toDate) {
        return repository.save(Booking.builder().roomId(roomId).customerId(customerId).fromDate(fromDate).toDate(toDate).build());
    }
}
