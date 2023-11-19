package org.openapitools.api;

import org.openapitools.model.Area;


import org.openapitools.persistence.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-19T14:12:38.522563+01:00[Europe/Berlin]")
@Controller
@RequestMapping("${openapi.weckerRestAPIOpenAPI30.base-path:/api/v1}")
public class AreaApiController implements AreaApi {

    @Autowired
    private AreaService service;
    private final NativeWebRequest request;

    @Autowired
    public AreaApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<Area> addArea(Area area) {
        try {
            Area persistedArea = service.persistArea(area);
            return ResponseEntity.ok(persistedArea);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @Override
    public ResponseEntity<List<Area>> getAllAreas() {
        try {
            List<Area> allAreas = service.getAllAreas();
            return ResponseEntity.ok(allAreas);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @Override
    public ResponseEntity<Area> getAreaById(Long areaId) {
        try {
            Area area = service.getAreaById(areaId);
            return ResponseEntity.ok(area);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @Override
    public ResponseEntity<Area> updateAreaViaId(Long areaId, Area area) {
        try {
            Area updatedArea = service.updateArea(areaId, area);
            return ResponseEntity.ok(updatedArea);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
