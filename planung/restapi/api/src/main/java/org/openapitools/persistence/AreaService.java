package org.openapitools.persistence;

import org.openapitools.model.Area;
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
        databaseService.getConnection();
        return null;
    }

    public Area getAreaById(Long areaId) throws IOException {
        return null;
    }

    public Area updateArea(Long areaId, Area area) throws IOException{
        return null;
    }
}
