package com.santex.santex.mapper;

import com.santex.santex.dto.response.TeamDTO;
import com.santex.santex.entity.Coach;
import com.santex.santex.entity.Person;
import com.santex.santex.entity.Player;
import com.santex.santex.entity.Team;

import java.util.List;
import java.util.stream.Collectors;

public class TeamMapper {

    public static Team mapToEntity(TeamDTO teamDTO) {
        Team team = new Team();
        team.setId(teamDTO.getId());
        team.setName(teamDTO.getName());
        team.setAddress(teamDTO.getAddress());
        team.setTla(teamDTO.getTla());
        team.setShortName(teamDTO.getShortName());
        team.setAreaName(teamDTO.getArea().getName());

        List<Person> persons;

        if (teamDTO.getSquad() != null || !teamDTO.getSquad().isEmpty()) {
            persons = teamDTO.getSquad().stream()
                    .map(PlayerMapper::mapToEntity)
                    .collect(Collectors.toList());
        } else {
            persons = List.of(CoachMapper.mapToEntity(teamDTO.getCoach()));
        }

        team.setPersons(persons);

        return team;
    }

    public static TeamDTO mapToDTO(Team team, boolean includeMembers) {
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setName(team.getName());
        teamDTO.setShortName(team.getShortName());
        teamDTO.setAddress(team.getAddress());
        teamDTO.setTla(team.getTla());

        if (includeMembers) {
            if (team.getPersons().size() > 1) {
                teamDTO.setSquad(
                        team.getPersons()
                                .stream()
                                .map(Player.class::cast)
                                .map(PlayerMapper::mapToDTO)
                                .collect(Collectors.toList()));
            } else if (team.getPersons().size() == 1) {
                teamDTO.setCoach(team.getPersons().stream()
                        .findFirst()
                        .map(Coach.class::cast)
                        .map(CoachMapper::mapToDTO)
                        .get());
            }
        }
        return teamDTO;
    }
}
