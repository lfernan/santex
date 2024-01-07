package com.santex.santex.mapper;

import com.santex.santex.dto.response.TeamDTO;
import com.santex.santex.entity.Team;

public class TeamMapper {

    public static Team mapToEntity(TeamDTO teamDTO) {
        Team team = new Team();
        team.setId(teamDTO.getId());
        team.setName(teamDTO.getName());
        team.setAddress(teamDTO.getAddress());
        team.setTla(teamDTO.getTla());
        team.setShortName();
    }
}
