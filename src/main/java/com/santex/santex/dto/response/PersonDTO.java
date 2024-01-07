package com.santex.santex.dto.response;

import lombok.Data;

@Data
public abstract class PersonDTO {
    private Integer id;
    private String name;
    private String dateOfBirth;
    private String nationality;
}
