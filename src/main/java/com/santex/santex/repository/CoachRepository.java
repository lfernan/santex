package com.santex.santex.repository;

import com.santex.santex.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CoachRepository extends JpaRepository<Coach, Integer>, NativeQuery{
    @Query(value = PERSON_BY_LEAGUE_CODE_TEAM_NAME_ROLE, nativeQuery = true)
    List<Coach> getCoachesByLeagueCodeAndRoleAndTeamName(String leagueCode, String role, String teamName);
}
