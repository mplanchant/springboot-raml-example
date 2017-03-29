package com.logiccache.hotel.api;

import com.logiccache.hotel.api.model.CreateBookingRequest;
import com.logiccache.hotel.api.model.CreateBookingResponse;
import com.logiccache.hotel.api.model.GetBookingsResponse;
import com.logiccache.hotel.domain.Booking;
import com.logiccache.hotel.services.BookingService;
import com.logiccache.hotel.util.MapperUtil;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

@Component
public class BookingControllerImpl implements BookingController {

    private final BookingService bookingService;

    private final DozerBeanMapper mapper;

    @Autowired
    public BookingControllerImpl(BookingService bookingService, DozerBeanMapper mapper) {
        this.bookingService = bookingService;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<List<GetBookingsResponse>> getBookings(String customerId, String roomId) {
        List<GetBookingsResponse> bookings = MapperUtil.mapList(mapper, bookingService.getBookings(roomId, customerId), GetBookingsResponse.class);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CreateBookingResponse> createBooking(@RequestBody CreateBookingRequest createBookingRequest) {
        Booking booking = bookingService.createBooking(createBookingRequest.getRoomId(), createBookingRequest.getCustomerId(), LocalDate.parse(createBookingRequest.getFromDate()), LocalDate.parse(createBookingRequest.getToDate()));
        return new ResponseEntity<>(new CreateBookingResponse().withMessage("Created: " + booking), HttpStatus.CREATED);
    }
}
