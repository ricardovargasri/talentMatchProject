package com.talentvistas.controller;

import com.talentvistas.dto.IdeaDto;
import com.talentvistas.model.Idea;
import com.talentvistas.security.CustomUserDetails;
import com.talentvistas.service.IdeaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ideas")
@RequiredArgsConstructor
public class IdeaController {

    private final IdeaService ideaService;

    @PostMapping
    public ResponseEntity<Idea> createIdea(
            @AuthenticationPrincipal CustomUserDetails userDetails,
            @Valid @RequestBody IdeaDto ideaDto) {
        Idea idea = ideaService.createIdea(userDetails.getUser().getId(), ideaDto);
        return ResponseEntity.ok(idea);
    }

    @GetMapping
    public ResponseEntity<List<Idea>> getAllIdeas() {
        return ResponseEntity.ok(ideaService.getAllIdeas());
    }

    @GetMapping("/creator/{creatorId}")
    public ResponseEntity<List<Idea>> getIdeasByCreator(@PathVariable Long creatorId) {
        return ResponseEntity.ok(ideaService.getIdeasByCreator(creatorId));
    }

    @GetMapping("/{ideaId}")
    public ResponseEntity<Idea> getIdeaById(@PathVariable Long ideaId) {
        return ResponseEntity.ok(ideaService.getIdeaById(ideaId));
    }

    @PostMapping("/{ideaId}/interest")
    public ResponseEntity<Void> showInterest(
            @PathVariable Long ideaId,
            @AuthenticationPrincipal CustomUserDetails userDetails) {
        ideaService.showInterest(ideaId, userDetails.getUser().getId());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Idea>> getIdeasByCategory(@PathVariable String category) {
        return ResponseEntity.ok(ideaService.getIdeasByCategory(category));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Idea>> getIdeasByStatus(@PathVariable String status) {
        return ResponseEntity.ok(ideaService.getIdeasByStatus(status));
    }
} 