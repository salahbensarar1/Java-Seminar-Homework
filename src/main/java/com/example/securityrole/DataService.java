package com.example.securityrole;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DataService {
    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private EntryRepository entryRepository;
    @Autowired
    private SpectatorRepository spectatorRepository;

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public List<Entry> getAllEntries() {
        return entryRepository.findAllWithRelations(); // Use the custom query
    }
    public List<Spectator> getAllSpectators() {
        return spectatorRepository.findAll();
    }
}