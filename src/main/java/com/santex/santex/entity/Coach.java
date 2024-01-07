package com.santex.santex.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("COACH")
public class Coach extends Person {
}
