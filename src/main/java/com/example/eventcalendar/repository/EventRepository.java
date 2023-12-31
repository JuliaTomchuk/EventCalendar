package com.example.eventcalendar.repository;

import com.example.eventcalendar.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository extends JpaRepository<EventEntity, UUID> {
}
