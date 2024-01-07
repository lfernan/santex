package com.santex.santex.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class CompetitionTeamsDTO {
    private CompetitionDTO competition;
    private List<TeamDTO> teams;
}
