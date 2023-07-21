package com.geekster.HotelManagement.repository;

import com.geekster.HotelManagement.model.HotelRoom;
import com.geekster.HotelManagement.model.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // we can write Or we can not write bcz CrudRepository have inside @Repository so, It's optional
public interface IRoomRepo extends CrudRepository<HotelRoom, Long> {
//    Custom Finder
//    if this method name will wrong then it will not work like below one
//    List<HotelRoom> findByRoomStatuz(Boolean roomStatus);
    List<HotelRoom> findByRoomStatus(Boolean roomStatus);  // Query will work on this method name which data and how to identify run and understand the code
    List<HotelRoom> findByRoomStatusAndRoomType(Boolean roomStatus, Type roomType);
    List<HotelRoom> findByRoomStatusAndRoomTypeAndRoomPriceLessThanEqualAndRoomPriceGreaterThan(Boolean roomStatus, Type type, Double upperLimit, Double lowerLimit);
    List<HotelRoom> findByRoomTypeOrderByRoomPriceDesc(Type type);
    List<HotelRoom> findByRoomTypeAndRoomPriceBetweenOrRoomType (Type type1, Double lPrice, Double uPrice, Type type2);

}
