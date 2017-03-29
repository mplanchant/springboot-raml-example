package com.logiccache.hotel.services.impl;

import com.logiccache.hotel.domain.Availability;
import com.logiccache.hotel.services.AvailabilityService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static com.logiccache.hotel.domain.AvailabilityStatus.AVAILABLE;
import static com.logiccache.hotel.domain.AvailabilityStatus.BOOKED;

@Component("availabilityService")
public class AvailabilityServiceImpl implements AvailabilityService {

    @Override
    public List<Availability> getAvailability(String roomId, LocalDate fromDate, LocalDate toDate) {
        return data();
    }

    private List<Availability> data() {
        Availability day1 = Availability.builder().roomId("003").date(LocalDate.of(2013, Month.JULY, 22)).availability(AVAILABLE).build();
        Availability day2 = Availability.builder().roomId("003").date(LocalDate.of(2013, Month.JULY, 23)).availability(BOOKED).build();
        Availability day3 = Availability.builder().roomId("003").date(LocalDate.of(2013, Month.JULY, 24)).availability(BOOKED).build();
        Availability day4 = Availability.builder().roomId("003").date(LocalDate.of(2013, Month.JULY, 25)).availability(AVAILABLE).build();
        return Arrays.asList(day1, day2, day3, day4);
    }
}
