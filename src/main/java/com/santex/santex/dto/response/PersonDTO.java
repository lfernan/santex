package com.santex.santex.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class PersonDTO {
    private Integer id;
    private String name;
    private String dateOfBirth;
    private String nationality;
}
