package com.santex.santex.service;

import com.santex.santex.dto.response.CoachDTO;
import com.santex.santex.dto.response.PersonDTO;
import com.santex.santex.dto.response.PlayerDTO;
import com.santex.santex.exception.SantexExceptionNotFound;
import com.santex.santex.mapper.CoachMapper;
import com.santex.santex.mapper.PlayerMapper;
import com.santex.santex.repository.CoachRepository;
import com.santex.santex.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private static final String COACH_ROLE = "COACH";
    private static final String PLAYER_ROLE = "PLAYER";
    private final PlayerRepository playerRepository;
    private final CoachRepository coachRepository;

    public PersonService(PlayerRepository playerRepository, CoachRepository coachRepository) {
        this.playerRepository = playerRepository;
        this.coachRepository = coachRepository;
    }

    public List<? extends PersonDTO> getPlayersOrCoachByLeagueAndTeamName(String leagueCode, String teamName) {
        List<PlayerDTO> playerDTOList = getPlayerDtoByLeagueCodeAndTeamName(leagueCode, teamName);

        if (playerDTOList.isEmpty()) {
            List<CoachDTO> coachDTOList = getCoachesDtoByLeagueCodeAndTeamName(leagueCode, teamName);
            if (coachDTOList.isEmpty())
                throw new SantexExceptionNotFound("Not data found for provided input");
            return coachDTOList;
        }

        return playerDTOList;
    }

    private List<PlayerDTO> getPlayerDtoByLeagueCodeAndTeamName(String leagueCode, String teamName) {
        return playerRepository.getPlayersByLeagueCodeAndRoleAndTeamName(leagueCode, PLAYER_ROLE, teamName)
                .stream()
                .map(PlayerMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    private List<CoachDTO> getCoachesDtoByLeagueCodeAndTeamName(String leagueCode, String teamName) {
        return coachRepository.getCoachesByLeagueCodeAndRoleAndTeamName(leagueCode, COACH_ROLE, teamName)
                .stream()
                .map(CoachMapper::mapToDTO)
                .collect(Collectors.toList());
    }
}
