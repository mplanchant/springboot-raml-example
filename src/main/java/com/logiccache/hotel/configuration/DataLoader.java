package com.logiccache.hotel.configuration;

import com.logiccache.hotel.domain.Availability;
import com.logiccache.hotel.domain.Booking;
import com.logiccache.hotel.repositories.AvailabilityRepository;
import com.logiccache.hotel.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

import static com.logiccache.hotel.domain.AvailabilityStatus.AVAILABLE;
import static com.logiccache.hotel.domain.AvailabilityStatus.BOOKED;

@Component
public class DataLoader implements ApplicationRunner {

    private final BookingRepository bookingRepository;

    private final AvailabilityRepository availabilityRepository;

    @Autowired
    public DataLoader(BookingRepository bookingRepository, AvailabilityRepository availabilityRepository) {
        this.bookingRepository = bookingRepository;
        this.availabilityRepository = availabilityRepository;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        createAvailabilityData();
        createBookingData();
    }

    private void createBookingData() {
        Booking booking1 = Booking.builder().roomId("001").customerId("100").fromDate(LocalDate.of(2017, Month.APRIL, 1)).toDate(LocalDate.of(2017, Month.APRIL, 10)).build();
        Booking booking2 = Booking.builder().roomId("001").customerId("200").fromDate(LocalDate.of(2017, Month.MAY, 12)).toDate(LocalDate.of(2017, Month.MAY, 15)).build();
        bookingRepository.save(Arrays.asList(booking1, booking2));
    }

    private void createAvailabilityData() {
        Availability day1 = Availability.builder().roomId("003").date(LocalDate.of(2013, Month.JULY, 22)).availability(AVAILABLE).build();
        Availability day2 = Availability.builder().roomId("003").date(LocalDate.of(2013, Month.JULY, 23)).availability(BOOKED).build();
        Availability day3 = Availability.builder().roomId("003").date(LocalDate.of(2013, Month.JULY, 24)).availability(BOOKED).build();
        Availability day4 = Availability.builder().roomId("003").date(LocalDate.of(2013, Month.JULY, 25)).availability(AVAILABLE).build();
        availabilityRepository.save(Arrays.asList(day1, day2, day3, day4));
    }

}