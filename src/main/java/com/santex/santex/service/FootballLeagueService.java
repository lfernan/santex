package com.santex.santex.service;

import com.santex.santex.dto.response.CompetitionDTO;
import com.santex.santex.dto.response.CompetitionTeamsDTO;
import com.santex.santex.entity.Competition;
import com.santex.santex.entity.Team;
import com.santex.santex.mapper.CompetitionMapper;
import com.santex.santex.mapper.TeamMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FootballLeagueService extends BaseService {

    private static final String ALL_IMPORTED = "ALL IMPORTED";
    private final String competitionByCode = "competitions/%s/";
    private final String competitionAndTeamByCode = "competitions/%s/teams";
    private final CompetitionService competitionService;

    public FootballLeagueService(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    public String importLeague(String leagueCode) {

        // 1- Do a request to get competition details and populate competitions/area

        Competition competition = CompetitionMapper.mapToEntity(getCompetitionByCode(leagueCode));

        // 2- Do a request to get competitions / teams and populate teams/areas
        CompetitionTeamsDTO competitionTeamsDTO = getCompetitionAndTeamByCode(leagueCode);

        // 3- Get all the teams data
        List<Team> teams = competitionTeamsDTO.getTeams().stream()
                .map(TeamMapper::mapToEntity)
                .collect(Collectors.toList());

        // 4- Associate teams and competitions and save them
        competition.setTeams(teams);

        competitionService.save(competition);

        return ALL_IMPORTED;
    }

    public CompetitionDTO getCompetitionByCode(String code) {
        return (CompetitionDTO) doExchange(String.format(competitionByCode, code), CompetitionDTO.class).getBody();
    }

    public CompetitionTeamsDTO getCompetitionAndTeamByCode(String code) {
        return (CompetitionTeamsDTO) doExchange(String.format(competitionAndTeamByCode, code), CompetitionTeamsDTO.class).getBody();
    }
}
