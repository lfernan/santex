package com.santex.santex.repository;

public interface NativeQuery {

    String PERSON_BY_LEAGUE_CODE_TEAM_NAME_ROLE = "SELECT p.*" +
            " FROM santex.person p" +
            " INNER JOIN santex.team t ON t.id = p.team_id AND (:teamName is null OR t.name = :teamName)" +
            " INNER JOIN santex.competition c ON c.id = t.competition_id AND c.code = :leagueCode" +
            " WHERE p.role = :role";
}
