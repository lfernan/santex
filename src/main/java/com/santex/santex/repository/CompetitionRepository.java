package com.santex.santex.repository;

import com.santex.santex.entity.Competition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompetitionRepository extends JpaRepository<Competition, Integer> {
    Optional<Competition> findCompetitionByCode(String code);
}
