package com.talentvistas.repository;

import com.talentvistas.model.Idea;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IdeaRepository extends JpaRepository<Idea, Long> {
    List<Idea> findByCreatorId(Long creatorId);
    List<Idea> findByStatus(String status);
    List<Idea> findByCategory(String category);
} 