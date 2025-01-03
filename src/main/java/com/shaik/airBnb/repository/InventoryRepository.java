package com.shaik.airBnb.repository;

import com.shaik.airBnb.entity.Inventory;
import com.shaik.airBnb.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    void deleteByDateAfterAndRoom(LocalDate date, Room room);
}
