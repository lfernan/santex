package com.santex.santex.service;

import com.santex.santex.dto.response.CoachDTO;
import com.santex.santex.dto.response.CompetitionDTO;
import com.santex.santex.dto.response.CompetitionTeamsDTO;
import com.santex.santex.dto.response.TeamDTO;
import com.santex.santex.entity.Team;
import com.santex.santex.mapper.CompetitionMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class FootballLeagueService extends BaseService {

    private final String competitionByCode = "competitions/%s/";
    private final String competitionAndTeamByCode = "competitions/%s/teams";
    private final CompetitionService competitionService;

    public FootballLeagueService(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    public String importLeague(String leagueCode) {

        // 1- Do a request to get competition details and populate competitions/area

        competitionService.save(CompetitionMapper.mapToEntity(getCompetitionByCode(leagueCode)));

        // 2- Do a request to get competitions / teams and populate teams/areas
        CompetitionTeamsDTO competitionTeamsDTO = getCompetitionAndTeamByCode(leagueCode);

        // 3- Get all the teams data
        List<Team> team = competitionTeamsDTO.getTeams().stream()
                .map()

        // 4- If squad list is null or empty import just the coach for the current team
        if(competitionTeamsDTO.getSquad() == null || competitionTeamsDTO.getSquad().isEmpty())
            //List<CoachDTO> coachDTOList =

        // 5- If the squad has data import them

        return competitionDTO.toString();
    }

    public CompetitionDTO getCompetitionByCode(String code) {
        return (CompetitionDTO) doExchange(String.format(competitionByCode, code), CompetitionDTO.class).getBody();
    }

    public CompetitionTeamsDTO getCompetitionAndTeamByCode(String code) {
        return (CompetitionTeamsDTO) doExchange(String.format(competitionAndTeamByCode, code), CompetitionTeamsDTO.class).getBody();
    }
}
