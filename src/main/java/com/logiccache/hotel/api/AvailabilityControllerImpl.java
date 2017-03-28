package com.logiccache.hotel.api;

import com.logiccache.hotel.api.model.GetAvailabilityByRoomIdResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@Component
public class AvailabilityControllerImpl implements AvailabilityController {
    @Override
    public ResponseEntity<List<GetAvailabilityByRoomIdResponse>> getAvailabilityByRoomId(String roomId, String fromDate, String toDate) {
        GetAvailabilityByRoomIdResponse day1 = new GetAvailabilityByRoomIdResponse()
                .withAvailability(GetAvailabilityByRoomIdResponse.Availability.AVAILABLE)
                .withDate(LocalDate.of(2013, Month.JULY, 22))
                .withRoomId("003");
        GetAvailabilityByRoomIdResponse day2 = new GetAvailabilityByRoomIdResponse()
                .withAvailability(GetAvailabilityByRoomIdResponse.Availability.BOOKED)
                .withDate(LocalDate.of(2013, Month.JULY, 23))
                .withRoomId("003");
        GetAvailabilityByRoomIdResponse day3 = new GetAvailabilityByRoomIdResponse()
                .withAvailability(GetAvailabilityByRoomIdResponse.Availability.BOOKED)
                .withDate(LocalDate.of(2013, Month.JULY, 24))
                .withRoomId("003");
        GetAvailabilityByRoomIdResponse day4 = new GetAvailabilityByRoomIdResponse()
                .withAvailability(GetAvailabilityByRoomIdResponse.Availability.AVAILABLE)
                .withDate(LocalDate.of(2013, Month.JULY, 25))
                .withRoomId("003");
        return new ResponseEntity<>(Arrays.asList(day1, day2, day3, day4), HttpStatus.OK);
    }
}
