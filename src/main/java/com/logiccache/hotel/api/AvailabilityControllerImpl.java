package com.logiccache.hotel.api;

import com.logiccache.hotel.api.model.GetAvailabilityByRoomIdResponse;
import com.logiccache.hotel.services.AvailabilityService;
import com.logiccache.hotel.util.MapperUtil;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class AvailabilityControllerImpl implements AvailabilityController {

    private final AvailabilityService availabilityService;

    private final DozerBeanMapper mapper;

    @Autowired
    public AvailabilityControllerImpl(AvailabilityService availabilityService, DozerBeanMapper mapper) {
        this.availabilityService = availabilityService;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<List<GetAvailabilityByRoomIdResponse>> getAvailabilityByRoomId(String roomId, String fromDate, String toDate) {
        List<GetAvailabilityByRoomIdResponse> availability =
                MapperUtil.mapList(mapper, availabilityService.getAvailability(roomId, LocalDate.parse(fromDate), LocalDate.parse(toDate)), GetAvailabilityByRoomIdResponse.class);
        return new ResponseEntity<>(availability, HttpStatus.OK);
    }
}
