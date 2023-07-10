package com.example.eventcalendar.mapper;

import com.example.eventcalendar.dto.EventDto;
import com.example.eventcalendar.entity.EventEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.time.ZonedDateTime;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class EventMapper {

   public abstract EventDto toDto(EventEntity entity);
    @Mapping(target = "dateTime",ignore = true)
   public abstract EventEntity toEntity(EventDto dto);
    @AfterMapping
    public EventEntity toZonedTime(EventDto dto, @MappingTarget EventEntity entity){
    entity.setDateTime(ZonedDateTime.of(dto.getDateTime(),dto.getTimeZoneId()));
    return entity;
    }

   public abstract List<EventDto> toDtoList(List <EventEntity> list);
}
