package com.santex.santex.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="role",
        discriminatorType = DiscriminatorType.STRING)
@Data
public class Person {
    @Id
    private Integer id;
    private String name;
    private String dateOfBirth;
    private String nationality;

}
