package com.santex.santex.dto.response;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public class PlayerDTO extends PersonDTO {
    private String position;
}
