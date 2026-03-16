package edu.famu.cop3060.yard.service;

import edu.famu.cop3060.yard.dto.*;
import edu.famu.cop3060.yard.store.InMemoryOpportunityStore;

import java.util.Optional;

public class OpportunitiesService {

    private final InMemoryOpportunityStore store;
    private int idCounter;

    public OpportunitiesService(InMemoryOpportunityStore store) {
        this.store = store;
        this.idCounter = store.findAll().size();
    }

    public OpportunityDTO create(CreateOpportunityDTO request) {

        idCounter++;

        String newId = String.format("opp-%03d", idCounter);

        OpportunityDTO dto = new OpportunityDTO();

        dto.setId(newId);
        dto.setTitle(request.getTitle());
        dto.setType(request.getType());
        dto.setSponsor(request.getSponsor());
        dto.setDeadline(request.getDeadline());
        dto.setDescription(request.getDescription());
        dto.setTags(request.getTags());
        dto.setUrl(request.getUrl());

        return store.save(dto);
    }

    public Optional<OpportunityDTO> update(String id, UpdateOpportunityDTO request) {

        OpportunityDTO dto = new OpportunityDTO();

        dto.setId(id);
        dto.setTitle(request.getTitle());
        dto.setType(request.getType());
        dto.setSponsor(request.getSponsor());
        dto.setDeadline(request.getDeadline());
        dto.setDescription(request.getDescription());
        dto.setTags(request.getTags());
        dto.setUrl(request.getUrl());

        return store.update(id, dto);
    }

    public boolean delete(String id) {
        return store.delete(id);
    }
}
