package com.geekster.UniversityEventManagement.controller;

import com.geekster.UniversityEventManagement.model.Department;
import com.geekster.UniversityEventManagement.model.Event;
import com.geekster.UniversityEventManagement.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class EventController {
    @Autowired
    EventService eventService;
//    Task -- 1 --> Add event
    @PostMapping("events")
    public String addEvents(@RequestBody @Valid List<Event> events) {
        return eventService.addEvents(events);
    }
//    Task -- 2 --> get all events by date

//    Task -- 3 --> Update event
    @PutMapping("events/eventId/{eventId}/location/{location}")
    public String updateEventInformationById(@PathVariable Long eventId, @PathVariable String location) {
        return eventService.updateEventInformationById(eventId, location);
    }
//    Task -- 4 --> Delete event
    @DeleteMapping("events/eventId/{eventId}")
    public String deleteEventsById(@PathVariable Long eventId) {
        return eventService.deleteEventsById(eventId);
    }
}
