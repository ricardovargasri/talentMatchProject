package com.talentvistas.service;

import com.talentvistas.dto.IdeaDto;
import com.talentvistas.model.Creator;
import com.talentvistas.model.Idea;
import com.talentvistas.model.Investor;
import com.talentvistas.repository.CreatorRepository;
import com.talentvistas.repository.IdeaRepository;
import com.talentvistas.repository.InvestorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IdeaService {
    
    private final IdeaRepository ideaRepository;
    private final CreatorRepository creatorRepository;
    private final InvestorRepository investorRepository;

    public Idea createIdea(Long creatorId, IdeaDto ideaDto) {
        Creator creator = creatorRepository.findById(creatorId)
            .orElseThrow(() -> new RuntimeException("Creator not found"));

        Idea idea = new Idea();
        idea.setTitle(ideaDto.getTitle());
        idea.setDescription(ideaDto.getDescription());
        idea.setCategory(ideaDto.getCategory());
        idea.setRequiredInvestment(ideaDto.getRequiredInvestment());
        idea.setBusinessPlan(ideaDto.getBusinessPlan());
        idea.setMarketAnalysis(ideaDto.getMarketAnalysis());
        idea.setExpectedReturn(ideaDto.getExpectedReturn());
        idea.setEstimatedTimeMonths(ideaDto.getEstimatedTimeMonths());
        idea.setCreator(creator);

        return ideaRepository.save(idea);
    }

    public List<Idea> getAllIdeas() {
        return ideaRepository.findAll();
    }

    public List<Idea> getIdeasByCreator(Long creatorId) {
        return ideaRepository.findByCreatorId(creatorId);
    }

    public Idea getIdeaById(Long ideaId) {
        return ideaRepository.findById(ideaId)
            .orElseThrow(() -> new RuntimeException("Idea not found"));
    }

    @Transactional
    public void showInterest(Long ideaId, Long investorId) {
        Idea idea = ideaRepository.findById(ideaId)
            .orElseThrow(() -> new RuntimeException("Idea not found"));
        
        Investor investor = investorRepository.findById(investorId)
            .orElseThrow(() -> new RuntimeException("Investor not found"));

        investor.getInterestedIdeas().add(idea);
        investorRepository.save(investor);
    }

    public List<Idea> getIdeasByCategory(String category) {
        return ideaRepository.findByCategory(category);
    }

    public List<Idea> getIdeasByStatus(String status) {
        return ideaRepository.findByStatus(status);
    }
} 