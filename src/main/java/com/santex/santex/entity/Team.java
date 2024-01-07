package com.santex.santex.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Team {
    @Id
    private Integer id;
    private String name;
    private String tla;
    private String shortName;
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="area_id", nullable=false)
    private Area area;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="competition_id", nullable=false)
    private Competition competition;

}
