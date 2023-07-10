package com.example.eventcalendar.service.impl;

import com.example.eventcalendar.dto.EventDto;
import com.example.eventcalendar.entity.EventEntity;
import com.example.eventcalendar.mapper.EventMapper;
import com.example.eventcalendar.repository.EventRepository;
import com.example.eventcalendar.service.EventService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.support.RequestContextUtils;

import java.time.ZoneId;
import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository repository;
    private final EventMapper mapper;

    @Override
    public EventDto save(EventDto event){

        EventEntity eventEntity = mapper.toEntity(event);

        EventEntity save = repository.save(eventEntity);
        return mapper.toDto(save);
    }

    @Override
    public List<EventDto> getAll(ZoneId zoneId) {
        List<EventEntity> all = repository.findAll();
        for(EventEntity eventEntity: all){
            eventEntity.setDateTime(eventEntity.getDateTime().withZoneSameInstant(zoneId));
        }
        List<EventDto> eventDtos = mapper.toDtoList(all);
        eventDtos.stream().forEach(e->e.setTimeZoneId(zoneId));
        return  eventDtos;

    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public List<EventDto> search(EventDto eventDto) {
        return null;
    }
}
