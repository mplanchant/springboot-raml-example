package com.logiccache.hotel.api;

import com.logiccache.hotel.api.model.CreateBookingsRequest;
import com.logiccache.hotel.api.model.CreateCreateBookingsRequestResponse;
import com.logiccache.hotel.api.model.GetObjectResponse;
import com.logiccache.hotel.domain.Booking;
import com.logiccache.hotel.services.BookingService;
import com.logiccache.hotel.util.MapperUtil;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

import static org.springframework.util.StringUtils.hasText;

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
    public ResponseEntity<List<GetObjectResponse>> getGetObjectResponses(String customerId, String roomId) {
        return new ResponseEntity<>(MapperUtil.mapList(mapper, bookings(customerId, roomId), GetObjectResponse.class), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CreateCreateBookingsRequestResponse> createCreateBookingsRequest(@Valid CreateBookingsRequest createBookingsRequest) {
        Booking booking = bookingService.createBooking(createBookingsRequest.getRoomId(), createBookingsRequest.getCustomerId(), LocalDate.parse(createBookingsRequest.getFromDate()), LocalDate.parse(createBookingsRequest.getToDate()));
        return new ResponseEntity<>(new CreateCreateBookingsRequestResponse().withMessage("Created: " + booking), HttpStatus.CREATED);    }

    private List<Booking> bookings(String customerId, String roomId) {
        List<Booking> bookings;
        if (hasText(customerId) && hasText(roomId)) {
            bookings = bookingService.getBookings(roomId, customerId);
        } else if (hasText(customerId)) {
            bookings = bookingService.getBookingsByCustomer(customerId);
        } else if (hasText(roomId)) {
            bookings = bookingService.getBookingsByRoom(roomId);
        } else {
            bookings = bookingService.getBookings();
        }
        return bookings;
    }
}
