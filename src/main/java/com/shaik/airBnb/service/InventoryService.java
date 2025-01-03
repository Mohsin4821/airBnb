package com.shaik.airBnb.service;

import com.shaik.airBnb.entity.Room;

public interface InventoryService {
    void initializeRoomForAYear(Room room);
    void deleteFutureInventories(Room room);
}
