package org.openapitools.persistence.service;

import org.openapitools.model.Area;
import org.openapitools.persistence.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;


@Component
public class AreaService {
    //todo
    @Autowired
    private DatabaseService databaseService;

    public Area persistArea(Area area) throws IOException {
        return null;
    }

    public List<Area> getAllAreas() throws IOException {
        return databaseService.query(Area.FIND_ALL, Area.class)
                .getResultList();
    }

    public Area getAreaById(Long areaId) throws IOException {
        return null;
    }

    public Area updateArea(Long areaId, Area area) throws IOException{
        return null;
    }
}
