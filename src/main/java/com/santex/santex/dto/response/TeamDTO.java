package com.santex.santex.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
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
