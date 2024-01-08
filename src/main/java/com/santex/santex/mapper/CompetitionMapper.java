package com.santex.santex.mapper;

import com.santex.santex.dto.response.CompetitionDTO;
import com.santex.santex.entity.Competition;

import java.awt.geom.Area;

public class CompetitionMapper {

    public static Competition mapToEntity(CompetitionDTO competitionDTO) {
        Competition competition = new Competition();
        competition.setId(competitionDTO.getId());
        competition.setCode(competitionDTO.getCode());
        competition.setName(competitionDTO.getName());
        competition.setAreaName(competitionDTO.getArea().getName());

        return competition;
    }

    public static CompetitionDTO mapToDTO(Competition competition) {
        CompetitionDTO competitionDTO = new CompetitionDTO();
        competitionDTO.setName(competition.getName());
        competitionDTO.setCode(competition.getCode());

        return  competitionDTO;
    }
}
