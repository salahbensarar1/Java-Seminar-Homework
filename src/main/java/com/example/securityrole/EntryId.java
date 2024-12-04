package com.example.securityrole;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EntryId implements Serializable {
    private Integer spectatorid;
    private Integer matchid;

    // Getters and setters
    public Integer getSpectatorid() {
        return spectatorid;
    }

    public void setSpectatorid(Integer spectatorid) {
        this.spectatorid = spectatorid;
    }

    public Integer getMatchid() {
        return matchid;
    }

    public void setMatchid(Integer matchid) {
        this.matchid = matchid;
    }

    // Equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntryId entryId = (EntryId) o;
        return Objects.equals(spectatorid, entryId.spectatorid) &&
                Objects.equals(matchid, entryId.matchid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spectatorid, matchid);
    }
}