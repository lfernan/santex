package com.santex.santex.repository;

import com.santex.santex.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer>, NativeQuery {

    @Query(value = PERSON_BY_LEAGUE_CODE_TEAM_NAME_ROLE, nativeQuery = true)
    List<Player> getPlayersByLeagueCodeAndRoleAndTeamName(String leagueCode, String role, String teamName);

}
