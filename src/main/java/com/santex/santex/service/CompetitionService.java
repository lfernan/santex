package com.santex.santex.service;

import com.santex.santex.entity.Competition;
import com.santex.santex.repository.CompetitionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CompetitionService {
    private final CompetitionRepository competitionRepository;

    public CompetitionService(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    @Transactional
    public Competition save(Competition competition) {
        return competitionRepository.save(competition);
    }

    public boolean existsCompetitionByCode(String code) {
        return competitionRepository.existsCompetitionByCode(code);
    }
}
