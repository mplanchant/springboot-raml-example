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
public class Booking {
    @Id
    private String id;
    private String roomId;
    private String customerId;
    private LocalDate fromDate;
    private LocalDate toDate;
}
