package com.santex.santex.mapper;

import com.santex.santex.dto.response.CoachDTO;
import com.santex.santex.entity.Coach;

public class CoachMapper {

    public static Coach mapToEntity(CoachDTO coachDTO) {
        Coach coach = new Coach();
        coach.setId(coachDTO.getId());
        coach.setName(coachDTO.getName());
        coach.setNationality(coachDTO.getNationality());
        coach.setDateOfBirth(coach.getDateOfBirth());

        return coach;
    }

    public static CoachDTO mapToDTO(Coach coach) {
        CoachDTO coachDTO = new CoachDTO();
        coachDTO.setName(coach.getName());
        coachDTO.setNationality(coach.getNationality());
        coachDTO.setDateOfBirth(coach.getDateOfBirth());

        return coachDTO;
    }
}
