package com.santex.santex.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class TeamDTO {
    private Integer id;
    private String name;
    private String tla;
    private String shortName;
    private String address;

    private AreaDTO area;
    private CoachDTO coach;
    private List<PlayerDTO> squad;
}
