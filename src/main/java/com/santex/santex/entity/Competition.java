package com.santex.santex.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Competition {
    @Id
    private Integer id;
    private String name;
    private String code;

    /*@OneToMany(mappedBy="competition", fetch = FetchType.LAZY)
    private Set<Team> teams;*/


    /* I decided to remove this relationship and instead just keep the areaName, because
     * Area as an object of search it is not requested so far in this implementation
     *
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="area_id", nullable=false)
    private Area area;*/
}
