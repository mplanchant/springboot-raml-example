package com.logiccache.hotel.repositories;

import com.logiccache.hotel.domain.Availability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

public class AvailabilityRepositoryImpl implements AvailabilityRepositoryCustom {

    private final MongoOperations operations;

    @Autowired
    public AvailabilityRepositoryImpl(MongoOperations operations) {
        this.operations = operations;
    }

    @Override
    public List<Availability> findByRoomIdAndDateAfterAndDateBefore(String roomId, LocalDate fromDate, LocalDate toDate) {
        return operations.find(query(where("roomId").is(roomId)).addCriteria(where("date").gte(fromDate).lt(toDate)), Availability.class);
    }
}