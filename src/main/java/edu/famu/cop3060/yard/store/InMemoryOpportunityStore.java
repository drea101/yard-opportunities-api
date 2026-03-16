package edu.famu.cop3060.yard.store;

import edu.famu.cop3060.yard.dto.OpportunityDTO;

import java.util.*;

public class InMemoryOpportunityStore {

    private Map<String, OpportunityDTO> opportunityMap = new HashMap<>();
    private List<OpportunityDTO> opportunityList = new ArrayList<>();

    public List<OpportunityDTO> findAll() {
        return opportunityList;
    }

    public OpportunityDTO save(OpportunityDTO dto) {
        opportunityMap.put(dto.getId(), dto);
        opportunityList.add(dto);
        return dto;
    }

    public Optional<OpportunityDTO> update(String id, OpportunityDTO dto) {

        if (!opportunityMap.containsKey(id)) {
            return Optional.empty();
        }

        opportunityMap.put(id, dto);

        for (int i = 0; i < opportunityList.size(); i++) {
            if (opportunityList.get(i).getId().equals(id)) {
                opportunityList.set(i, dto);
                break;
            }
        }

        return Optional.of(dto);
    }

    public boolean delete(String id) {

        if (!opportunityMap.containsKey(id)) {
            return false;
        }

        opportunityMap.remove(id);
        opportunityList.removeIf(o -> o.getId().equals(id));

        return true;
    }
}
