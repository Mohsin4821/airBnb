package com.shaik.airBnb.service;

import com.shaik.airBnb.dto.HotelDto;

public interface HotelService {
    HotelDto createNewHotel(HotelDto hotelDto);
    HotelDto getHotelById(Long id);
    HotelDto updateHotelById(Long id,HotelDto hotelDto);
    void deleteHotelById(Long id);
    void activateHotel(Long hotelId);
}
