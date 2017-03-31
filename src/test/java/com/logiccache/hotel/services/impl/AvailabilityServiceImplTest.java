package com.logiccache.hotel.services.impl;

import com.logiccache.hotel.domain.Availability;
import com.logiccache.hotel.repositories.AvailabilityRepository;
import com.logiccache.hotel.services.AvailabilityService;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class AvailabilityServiceImplTest {

    private AvailabilityService service;

    private AvailabilityRepository mockAvailabilityRepository;

    @Before
    public void setUp() throws Exception {
        mockAvailabilityRepository = mock(AvailabilityRepository.class);
        service = new AvailabilityServiceImpl(mockAvailabilityRepository);
    }

    @Test
    public void testGetAvailabilityWithRoomId() throws Exception {
        // Create the input (request) data for the test
        String roomId = "roomId";

        // Specify what we want the mocks to do (when they are called)
        when(mockAvailabilityRepository.findByRoomId(roomId)).thenReturn(Arrays.asList(new Availability()));

        // Call the object-under-test (passing the request data)
        List<Availability> result = service.getAvailability(roomId);

        // Check the final state
        assertThat(result).hasSize(1);

        // Check that the object-under-test used the mocks as expected
        verify(mockAvailabilityRepository, times(1)).findByRoomId(roomId);
    }

    @Test
    public void testFindByRoomId() throws Exception {
        // Create the input (request) data for the test
        String roomId = "roomId";
        LocalDate date1 = LocalDate.parse("2010-08-03");
        LocalDate date2 = LocalDate.parse("2013-07-22");

        // Specify what we want the mocks to do (when they are called)
        when(mockAvailabilityRepository.findByRoomIdAndDateAfterAndDateBefore(roomId, date1, date2)).thenReturn(Arrays.asList(new Availability()));

        // Call the object-under-test (passing the request data)
        List<Availability> result = service.getAvailability(roomId, date1, date2);

        // Check the final state
        assertThat(result).hasSize(1);

        // Check that the object-under-test used the mocks as expected
        verify(mockAvailabilityRepository, times(1)).findByRoomIdAndDateAfterAndDateBefore(roomId, date1, date2);
    }
}