package com.santex.santex.mapper;

import com.santex.santex.dto.response.CompetitionDTO;
import com.santex.santex.entity.Area;
import com.santex.santex.entity.Competition;

public class CompetitionMapper {

    public static Competition mapToEntity(CompetitionDTO response){
        Competition competition = new Competition();
        competition.setId(response.getId());
        competition.setCode(response.getCode());
        competition.setName(response.getName());

        Area area = AreaMapper.mapToEntity(response.getArea());
        competition.setArea(area);

        return competition;
    }
}
