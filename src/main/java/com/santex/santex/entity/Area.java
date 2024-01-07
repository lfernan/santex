package com.santex.santex.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Set;

/*@Data
@Entity*/
public class Area {
    //@Id
    private Integer id;
    private String name;

    /*@OneToMany(mappedBy="area", fetch = FetchType.LAZY)
    private Set<Team> teams;

    @OneToMany(mappedBy="area", fetch = FetchType.LAZY)
    private Set<Competition> competitions;*/
}
