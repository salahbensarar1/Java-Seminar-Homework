package com.example.securityrole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EntryRepository extends JpaRepository<Entry, EntryId> {
    @Query("SELECT e FROM Entry e JOIN FETCH e.spectator JOIN FETCH e.match")
    List<Entry> findAllWithRelations();
}
