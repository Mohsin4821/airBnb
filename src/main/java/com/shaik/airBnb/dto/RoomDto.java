package com.shaik.airBnb.dto;

import java.math.BigDecimal;
import java.util.List;

public class RoomDto {
    private Long id;
    private String type;
    private BigDecimal basePrice;
    private List<String> photos;
    private List<String> amenities;
    private Integer totalCount;
    private Integer capacity;
}
