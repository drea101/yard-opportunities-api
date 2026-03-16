package edu.famu.cop3060.yard.controller;

import edu.famu.cop3060.yard.dto.*;
import edu.famu.cop3060.yard.service.OpportunitiesService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/opportunities")
public class OpportunitiesController {

    private final OpportunitiesService service;

    public OpportunitiesController(OpportunitiesService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<OpportunityDTO> create(
            @Valid @RequestBody CreateOpportunityDTO request) {

        OpportunityDTO created = service.create(request);

        URI location = URI.create("/api/opportunities/" + created.getId());

        return ResponseEntity
                .created(location)
                .body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OpportunityDTO> update(
            @PathVariable String id,
            @Valid @RequestBody UpdateOpportunityDTO request) {

        Optional<OpportunityDTO> result = service.update(id, request);

        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {

        boolean deleted = service.delete(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
