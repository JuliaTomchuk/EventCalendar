package com.example.eventcalendar.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="persons")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User implements UserDetails {
    @Id
    @GeneratedValue
    private UUID id;
    private String username;
    private char[] password;
    private String email;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EventEntity> eventList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getUsername().equals(user.getUsername()) && Arrays.equals(getPassword(), user.getPassword()) && getEmail().equals(user.getEmail()) && Objects.equals(getEventList(), user.getEventList());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getUsername(), getEmail(), getEventList());
        result = 31 * result + Arrays.hashCode(getPassword());
        return result;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
