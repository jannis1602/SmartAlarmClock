package org.openapitools.api;

import org.openapitools.model.PresenceLog;


import org.openapitools.model.Status;
import org.openapitools.persistence.WaveSensorApiService;
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
public class WaveSensorApiController implements WaveSensorApi {

    @Autowired
    private WaveSensorApiService waveSensorService;

    //todo create area etc when they dont exist and dont just throw error
    private final NativeWebRequest request;

    @Autowired
    public WaveSensorApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }


    @Override
    public ResponseEntity<PresenceLog> addPresenceLog(PresenceLog presenceLog) {
        try {
            PresenceLog persistedPresenceLog = waveSensorService.persistPresenceLog(presenceLog);
            return ResponseEntity.ok(persistedPresenceLog);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @Override
    public ResponseEntity<PresenceLog> getPresenceLogById(Long logId) {
        try {
            PresenceLog presenceLog = waveSensorService.getPresenceLogById(logId);
            return ResponseEntity.ok(presenceLog);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @Override
    public ResponseEntity<List<PresenceLog>> getPresenceLogs() {
        try {
            List<PresenceLog> presenceLogs = waveSensorService.getAllPresenceLogs();
            return ResponseEntity.ok(presenceLogs);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
