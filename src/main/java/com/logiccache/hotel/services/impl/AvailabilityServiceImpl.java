package com.logiccache.hotel.services.impl;

import com.logiccache.hotel.domain.Availability;
import com.logiccache.hotel.repositories.AvailabilityRepository;
import com.logiccache.hotel.services.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component("availabilityService")
public class AvailabilityServiceImpl implements AvailabilityService {

    private final AvailabilityRepository repository;

    @Autowired
    public AvailabilityServiceImpl(AvailabilityRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Availability> getAvailability(String roomId, LocalDate fromDate, LocalDate toDate) {
        return repository.findAll();
    }
}
