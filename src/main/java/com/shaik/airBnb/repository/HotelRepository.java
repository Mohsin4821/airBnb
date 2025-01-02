package com.shaik.airBnb.repository;

import com.shaik.airBnb.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Long> {

}
