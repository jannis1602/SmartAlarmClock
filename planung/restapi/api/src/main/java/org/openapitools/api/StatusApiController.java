package org.openapitools.api;

import org.openapitools.model.Area;
import org.openapitools.model.Status;


import org.openapitools.persistence.StatusApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-19T14:12:38.522563+01:00[Europe/Berlin]")
@Controller
@RequestMapping("${openapi.weckerRestAPIOpenAPI30.base-path:/api/v1}")
public class StatusApiController implements StatusApi {

    @Autowired
    private StatusApiService service;
    private final NativeWebRequest request;

    @Autowired
    public StatusApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }


    @Override
    public ResponseEntity<Status> addStatus(Status status) {
        try {
            Status persistStatus = service.persistStatus(status);
            return ResponseEntity.ok(persistStatus);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @Override
    public ResponseEntity<List<Status>> getAllStatis() {
        try {
            List<Status> stati = service.getAllStati();
            return ResponseEntity.ok(stati);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @Override
    public ResponseEntity<Status> getStatusViaId(Long statusId) {
        try {
            Status status = service.getStatusById(statusId);
            return ResponseEntity.ok(status);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @Override
    public ResponseEntity<Status> updateStatusViaId(Long statusId, Status status) {
        try {
            Status updatedStatus = service.updateStatus(statusId, status);
            return ResponseEntity.ok(updatedStatus);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
