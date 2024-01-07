package com.santex.santex.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class CompetitionDTO {
    private Integer id;
    private String name;
    private String code;
    private AreaDTO area;
    private List<TeamDTO> teams;
}
