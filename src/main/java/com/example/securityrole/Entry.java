package com.example.securityrole;

import jakarta.persistence.*;

import java.sql.Time;
@Entity
@Table(name = "entries")
public class Entry {

    @EmbeddedId
    private EntryId id; // Composite key

    @ManyToOne
    @MapsId("spectatorid") // Maps spectatorid field in EntryId
    @JoinColumn(name = "spectatorid")
    private Spectator spectator;

    @ManyToOne
    @MapsId("matchid") // Maps matchid field in EntryId
    @JoinColumn(name = "matchid")
    private Match match;

    private java.sql.Time timestamp;

    // Getters and Setters
    public EntryId getId() {
        return id;
    }

    public void setId(EntryId id) {
        this.id = id;
    }

    public Spectator getSpectator() {
        return spectator;
    }

    public void setSpectator(Spectator spectator) {
        this.spectator = spectator;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Time getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Time timestamp) {
        this.timestamp = timestamp;
    }
}