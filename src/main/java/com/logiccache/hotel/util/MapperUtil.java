package com.logiccache.hotel.util;

import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

public class MapperUtil {
    public static <T, U> List<U> mapList(final Mapper mapper, final List<T> source, final Class<U> destinationType) {
        final List<U> dest = new ArrayList<>();
        for (T element : source) {
            dest.add(mapper.map(element, destinationType));
        }
        return dest;
    }

}
