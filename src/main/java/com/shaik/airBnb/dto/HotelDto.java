package com.shaik.airBnb.dto;

import lombok.Data;

import java.util.List;

@Data
public class HotelDto {

    private Long id;
    private String name;
    private String city;
    private List<String> photos;
    private List<String> amenities;
    private Boolean active;
}
