package com.santex.santex.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PLAYER")
public class Player extends Person {
    private String position;
}
