package com.geekster.HotelManagement.controller;

import com.geekster.HotelManagement.model.HotelRoom;
import com.geekster.HotelManagement.model.Type;
import com.geekster.HotelManagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class roomController {
    @Autowired // dependency inject
    RoomService roomService; // access of the service class

//    READ // Get Rooms
    @GetMapping("rooms")
    public Iterable<HotelRoom> getAllRooms() { // Iterable is the parent so, we can not take as list return type read and see crudRepository
        return roomService.getAlRooms();
    }

//    Create / post // add single room at a time
    @PostMapping("rooms")
    public String addRoom(@RequestBody HotelRoom hotelRoom) {
        return roomService.addRoom(hotelRoom);
    }

//    Add multiple room at a time
    @PostMapping("rooms/addRooms")
    public String addRooms(@RequestBody List<HotelRoom> hotelRoom) {
        return roomService.addRooms(hotelRoom);
    }

//    Get Hotel room by id //GET//READ
    @GetMapping("rooms/{roomId}")
    public HotelRoom getRoomsById(@PathVariable Long roomId) {
        return roomService.getRoomsById(roomId);
    }

//    ExistById() // return type boolean // GET type
    @GetMapping("rooms/{roomId}/exists")
    public Boolean isExistsRoomById(@PathVariable Long roomId) {
        return roomService.isExistsRoomById(roomId);
    }

//    Count() // Get Type
    @GetMapping("rooms/counts")
    public Long getRoomsCounts() {
        return roomService.getRoomsCount();
    }

//    deleteById() // Delete Type
    @DeleteMapping("rooms/{roomId}")
    public String deleteRoomsById(@PathVariable Long roomId) {
        return roomService.deleteRoomById(roomId);
    }

    @DeleteMapping("rooms")
    public String deleteAllRooms() {
        return roomService.deleteAllRooms();
    }

    @PutMapping("rooms/updateById/{roomId}/{type}")
    public String updateRoomInformationById(@PathVariable Long roomId, @PathVariable Type type) {
        return roomService.updateRoomInformationById(roomId, type);
    }

//    Custom Finder ******************88
//    Find  room by status
    @GetMapping("rooms/status/{status}")
    public List<HotelRoom> getRoomsByStatus(@PathVariable Boolean status) {
        return roomService.getRoomsByStatus(status);
    }

//    find room by status and type
    @GetMapping("rooms/status/{status}/type/{type}")
    public List<HotelRoom> getRoomByStatusAndType(@PathVariable Boolean status, @PathVariable Type type) {
        return roomService.getRoomByStatusAndType(status, type);
    }

//    find room by status and type and price range lower and upper
    @GetMapping("rooms/status/{status}/type/{type}/priceRange")
    public List<HotelRoom> getRoomsByStatusAndTypeAndPriceRange(@PathVariable Boolean status, @PathVariable Type type, @RequestParam Double uPrice, @RequestParam Double lPrice) {
        return roomService.getRoomsByStatusAndTypeAndPriceRange(status, type, uPrice, lPrice);
    }

//    Find rooms by type and order desc or price
    @GetMapping("rooms/type/{roomType}")
    public List<HotelRoom> getRoomsByTypeAndPriceSortedDesc(@PathVariable Type roomType) {
        return roomService.getRoomsByTypeAndPriceSortedDesc(roomType);
    }

//    Find rooms by [type and (Price Range/between)] or type = AC
    @GetMapping("rooms/type1/{roomType1}/type2/{roomType2}")
    public List<HotelRoom> getRoomsBudgetedAcOrNonAc(@PathVariable Type roomType1, @PathVariable Type roomType2, @RequestParam Double lPrice, @RequestParam Double uPrice) {
        return roomService.getRoomsBudgetedAcOrNonAc(roomType1, lPrice, uPrice, roomType2);
    }
}
