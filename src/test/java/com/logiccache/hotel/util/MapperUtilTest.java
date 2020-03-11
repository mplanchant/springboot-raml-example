package com.logiccache.hotel.util;

import com.logiccache.hotel.api.model.GetObjectResponse;
import com.logiccache.hotel.domain.Booking;
import org.dozer.DozerBeanMapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MapperUtilTest {

    @Autowired
    private DozerBeanMapper mapper;

    @Test
    @Ignore
    public void testAssembleSomeObject() throws Exception {
        Booking source = Booking.builder().roomId("room").customerId("customer").fromDate(LocalDate.of(2010, Month.AUGUST, 21)).toDate(LocalDate.of(2010, Month.AUGUST, 22)).build();
        GetObjectResponse destination = mapper.map(source, GetObjectResponse.class);
        Booking mappedSource = mapper.map(destination, Booking.class);
        assertEquals("fields not mapped correctly", source, mappedSource);
    }
}