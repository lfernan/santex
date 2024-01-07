package com.santex.santex.mapper;

import com.santex.santex.dto.response.AreaDTO;
import com.santex.santex.entity.Area;

public class AreaMapper {

    public static Area mapToEntity(AreaDTO response){
        Area area = new Area();
        area.setId(response.getId());
        area.setName(response.getName());

        return area;
    }
}
