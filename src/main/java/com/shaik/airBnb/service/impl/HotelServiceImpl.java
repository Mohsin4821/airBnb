package com.shaik.airBnb.service.impl;

import com.shaik.airBnb.dto.HotelDto;
import com.shaik.airBnb.entity.Hotel;
import com.shaik.airBnb.entity.Room;
import com.shaik.airBnb.exceptions.ResourceNotFoundException;
import com.shaik.airBnb.repository.HotelRepository;
import com.shaik.airBnb.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
@Slf4j
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;
    @Override
    public HotelDto createNewHotel(HotelDto hotelDto) {
        log.info("Creating a new hotel with name: {}",hotelDto.getName());
        Hotel hotel=modelMapper.map(hotelDto,Hotel.class);
        hotel.setActive(false);
        hotel=hotelRepository.save(hotel);
        log.info("Created a new hotel with ID: {}", hotelDto.getId());
        return modelMapper.map(hotel,HotelDto.class);
    }

    @Override
    public HotelDto getHotelById(Long id) {
        return null;
    }

    @Override
    public HotelDto updateHotelById(Long id, HotelDto hotelDto) {
        log.info("Getting the hotel with ID: {}",id);
        Hotel hotel=hotelRepository
                .findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Hotel not found with ID: "+id));
        return modelMapper.map(hotel,HotelDto.class);
    }

    @Override
    public void deleteHotelById(Long id) {
        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: "+id));

        hotelRepository.deleteById(id);
        for(Room room: hotel.getRooms()) {
            inventoryService.deleteFutureInventories(room);
        }
    }

    @Override
    public void activateHotel(Long hotelId) {
        log.info("Activating the hotel with ID: {}", hotelId);
        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: "+hotelId));

        hotel.setActive(true);
        // assuming only do it once
        for(Room room: hotel.getRooms()) {
            inventoryService.initializeRoomForAYear(room);
        }
    }
}
