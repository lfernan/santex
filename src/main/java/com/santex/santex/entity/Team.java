package com.santex.santex.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Team {
    @Id
    private Integer id;
    private String name;
    private String tla;
    private String shortName;
    private String address;
    private String areaName;
    private Integer competitionId;

    /*
    * I decided this approach to store all the people that belong to one team, but another good approach it would be
    * to have two separate tables one for coach and another for players
    * */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "teamId")
    private List<Person> persons;

    /* I decided to remove this relationship and instead just keep the areaName, because
     * Area as an object for search endpoints that it is not requested so far in this implementation
     *
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="area_id", nullable=false)
        private Area area;
     */
}
