package com.logiccache.hotel.api;

import com.logiccache.hotel.api.model.GetObjectResponse;
import com.logiccache.hotel.domain.Availability;
import com.logiccache.hotel.services.AvailabilityService;
import com.logiccache.hotel.util.MapperUtil;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.util.StringUtils.hasText;

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
    public ResponseEntity<List<GetObjectResponse>> getGetObjectResponses(@PathVariable String roomId, String fromDate, String toDate) {
        List<Availability> availability;
        if (hasText(fromDate) && hasText(toDate)) {
            availability = availabilityService.getAvailability(roomId, LocalDate.parse(fromDate), LocalDate.parse(toDate));
        } else {
            availability = availabilityService.getAvailability(roomId);
        }
        return new ResponseEntity<>(MapperUtil.mapList(mapper, availability, GetObjectResponse.class), HttpStatus.OK);
    }
}
