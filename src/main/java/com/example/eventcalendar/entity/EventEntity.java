package com.example.eventcalendar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Setter
@Getter
@ToString
@Table(name = "entities")
public class EventEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private String description;
    private String name;
    @Column(columnDefinition = "timestamptz")
    private ZonedDateTime dateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventEntity that)) return false;
        return Objects.equals(getDescription(), that.getDescription()) && getName().equals(that.getName()) && getDateTime().equals(that.getDateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription(), getName(), getDateTime());
    }
}
