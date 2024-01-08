package com.santex.santex.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
public class PlayerDTO extends PersonDTO {
    private String position;
}
