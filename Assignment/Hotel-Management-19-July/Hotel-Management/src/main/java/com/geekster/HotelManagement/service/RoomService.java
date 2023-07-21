package com.geekster.HotelManagement.service;

import com.geekster.HotelManagement.model.HotelRoom;
import com.geekster.HotelManagement.model.Type;
import com.geekster.HotelManagement.repository.IRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    IRoomRepo iRoomRepo;

    public Iterable<HotelRoom> getAlRooms() {
        return iRoomRepo.findAll();
    }

    public String addRoom(HotelRoom hotelRoom) {

//        if(iRoomRepo.save(hotelRoom) != null){
//            return "Added Successfully";
//        }else {
//            return "Not added";
//        }

//        or we can use simple as
        iRoomRepo.save(hotelRoom);
        return "Added Successfully";
    }

//    for adding multiple rooms
    public String addRooms(List<HotelRoom> hotelRoom) {
        iRoomRepo.saveAll(hotelRoom);
//        return "Rooms Added Successfully!!!" + hotelRoom;  // it will show all hotelRoom list show in console
        return "Rooms Added Successfully!!!";
    }

    public HotelRoom getRoomsById(Long roomId) {
        Optional<HotelRoom> optionalHotelRoom = iRoomRepo.findById(roomId);
        if(optionalHotelRoom.isEmpty()) { // without this exception throw so we must use this
            return null;
        }
        return optionalHotelRoom.get();
    }

    public Boolean isExistsRoomById(Long roomId) {
        return iRoomRepo.existsById(roomId);
    }

    public Long getRoomsCount() {
        return iRoomRepo.count();
    }

    public String deleteRoomById(Long roomId) {
        iRoomRepo.deleteById(roomId);
        return "Room For Id : " + roomId + " Successfully Deleted";
    }

    public String deleteAllRooms() {
        iRoomRepo.deleteAll();
        return "All Rooms Successfully Deleted!!";
    }

    public String updateRoomInformationById(Long roomId, Type type) {
//        Method - 1 *******************************

//        Optional<HotelRoom> hotelRoom = iRoomRepo.findById(roomId);
//        if(hotelRoom.get().getRoomId().equals(roomId)) {
//            hotelRoom.get().setRoomType(type); // we need to save so use that otherwise will not update
//            iRoomRepo.save(hotelRoom.get());
//            return "For Room ID : " + roomId + " Updated Successfully";
//        }
//        return "For Room ID : " + roomId + " Not Updated bcz not exist";

//        Method -- 2 ***************************

//        Iterable<HotelRoom> hotelRooms = iRoomRepo.findAll();
//        for(HotelRoom hotelRoom : hotelRooms) {
//            if(hotelRoom.getRoomId().equals(roomId)) {
//                hotelRoom.setRoomType(type);
//                iRoomRepo.save(hotelRoom);
//                return "For Room ID : " + roomId + " Updated Successfully";
//            }
//        }
//        return "For Room ID : " + roomId + " Not Updated bcz not exist";

//        Method -- 3 ******************************************8
        Optional<HotelRoom> hotelRoomOptional = iRoomRepo.findById(roomId);
//        we want actual object so we use
        HotelRoom hotelRoom = null;
        if(hotelRoomOptional.isPresent()) {
            hotelRoom = hotelRoomOptional.get();
        }else {
            return "For Room ID : " + roomId + " Not Updated bcz not exist";
        }
        hotelRoom.setRoomType(type);
        iRoomRepo.save(hotelRoom);
        return "For Room ID : " + roomId + " Updated Successfully";
    }

    public List<HotelRoom> getRoomsByStatus(Boolean status) {
        return iRoomRepo.findByRoomStatus(status);
    }

    public List<HotelRoom> getRoomByStatusAndType(Boolean status, Type type) {
        return iRoomRepo.findByRoomStatusAndRoomType(status, type);
    }

    public List<HotelRoom> getRoomsByStatusAndTypeAndPriceRange(Boolean status, Type type, Double uPrice, Double lPrice) {
        return iRoomRepo.findByRoomStatusAndRoomTypeAndRoomPriceLessThanEqualAndRoomPriceGreaterThan(status, type, uPrice, lPrice);
    }

    public List<HotelRoom> getRoomsByTypeAndPriceSortedDesc(Type type) {
        return iRoomRepo.findByRoomTypeOrderByRoomPriceDesc(type);
    }

    public List<HotelRoom> getRoomsBudgetedAcOrNonAc(Type roomType1, Double lPrice, Double uPrice, Type roomType2) {
        return iRoomRepo.findByRoomTypeAndRoomPriceBetweenOrRoomType(roomType1, lPrice, uPrice, roomType2);
    }
}
