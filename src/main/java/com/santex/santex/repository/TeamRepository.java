package com.santex.santex.repository;

import com.santex.santex.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository  extends JpaRepository<Team, Integer> {

    Optional<Team> findTeamByName(String name);
}
