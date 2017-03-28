package com.logiccache.hotel.api;

import com.logiccache.hotel.api.model.CreateBookingRequest;
import com.logiccache.hotel.api.model.CreateBookingResponse;
import com.logiccache.hotel.api.model.GetBookingsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@Component
public class BookingControllerImpl implements BookingController {
    @Override
    public ResponseEntity<List<GetBookingsResponse>> getBookings(String customerId, String roomId) {
        GetBookingsResponse booking = new GetBookingsResponse()
                .withCustomerId("100")
                .withRoomId("001")
                .withFromDate(LocalDate.of(2010, Month.AUGUST, 22))
                .withToDate(LocalDate.of(2010, Month.AUGUST, 23));
        return new ResponseEntity<>(Arrays.asList(booking), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CreateBookingResponse> createBooking(CreateBookingRequest createBookingRequest) {
        CreateBookingResponse createBookingResponse = new CreateBookingResponse().withMessage("Created");
        return new ResponseEntity<>(createBookingResponse, HttpStatus.CREATED);
    }
}
