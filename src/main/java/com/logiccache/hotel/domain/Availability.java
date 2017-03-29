package com.logiccache.hotel.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Availability {
    @Id
    private String id;
    private String roomId;
    private AvailabilityStatus availability;
    private LocalDate date;
}
