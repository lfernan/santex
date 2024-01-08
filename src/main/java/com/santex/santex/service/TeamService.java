package com.santex.santex.service;

import com.santex.santex.dto.response.TeamDTO;
import com.santex.santex.exception.SantexExceptionNotFound;
import com.santex.santex.mapper.TeamMapper;
import com.santex.santex.repository.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public TeamDTO getTeamDTOByName(String name, boolean includeMembers) {
        return teamRepository.findTeamByName(name)
                .map(team -> TeamMapper.mapToDTO(team, includeMembers))
                .orElseThrow(() -> new SantexExceptionNotFound("Team not found with name " + name));
    }

    public boolean existsTeamById(Integer id) {
        return teamRepository.findById(id).isPresent();
    }
}
