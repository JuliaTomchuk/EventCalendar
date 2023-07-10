package com.example.eventcalendar.service;


import com.example.eventcalendar.dto.EventDto;

import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

public interface EventService {

    EventDto save(EventDto event);
    List<EventDto> getAll(ZoneId zoneId);
    void delete(UUID id);
    List<EventDto> search(EventDto eventDto);

}
