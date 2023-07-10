package com.example.eventcalendar.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;
import java.util.UUID;

@Data
public class EventDto {
    private UUID id;
    private String description;
    private String name;
    private LocalDateTime dateTime;
    private ZoneId timeZoneId;

}

