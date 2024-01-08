package com.santex.santex.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue("PLAYER")
@EqualsAndHashCode(callSuper=false)
@Data
public class Player extends Person {
    private String position;
}
