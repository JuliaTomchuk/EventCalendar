package com.example.eventcalendar.web;

import com.example.eventcalendar.dto.EventDto;
import com.example.eventcalendar.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/event")
public class EventController {
    private final EventService service;
  @PostMapping
    public ResponseEntity<EventDto> save(@RequestBody EventDto dto, ZoneId zoneId){

      dto.setTimeZoneId(zoneId);
      EventDto save = service.save(dto);
      return ResponseEntity.ok(save);
  }
  @GetMapping
  public List<EventDto> getAll(ZoneId id){
      return service.getAll(id);
  }
}
