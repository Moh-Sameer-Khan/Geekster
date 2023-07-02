package com.geekster.UniversityEventManagement.service;

import com.geekster.UniversityEventManagement.model.Event;
import com.geekster.UniversityEventManagement.model.Student;
import com.geekster.UniversityEventManagement.repository.IEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    IEventRepo iEventRepo;

    public String addEvents(List<Event> events) {
        iEventRepo.saveAll(events);
        return "Events Added Successfully";
    }

    public String updateEventInformationById(Long eventId, String location) {
        Optional<Event> eventOptional = iEventRepo.findById(eventId);
//        we want actual object so we use
        Event event = null;
        if(eventOptional.isPresent()) {
            event = eventOptional.get();
        }else {
            return "For Event ID : " + eventId + " Not Updated bcz not exist";
        }
        event.setEventLocation(location);
        iEventRepo.save(event);
        return "For Event ID : " + eventId + " Updated Successfully";
    }

    public String deleteEventsById(Long eventId) {
        iEventRepo.deleteById(eventId);
        return "Event For Id : " + eventId + " Successfully Deleted";
    }
}
