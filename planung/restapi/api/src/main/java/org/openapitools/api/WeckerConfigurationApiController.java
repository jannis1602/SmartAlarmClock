package org.openapitools.api;

import org.openapitools.model.ModelConfiguration;
import org.openapitools.persistence.WeckerConfigurationApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import javax.annotation.Generated;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-19T14:12:38.522563+01:00[Europe/Berlin]")
@Controller
@RequestMapping("${openapi.weckerRestAPIOpenAPI30.base-path:/api/v1}")
public class WeckerConfigurationApiController implements WeckerConfigurationApi {

    @Autowired
    private WeckerConfigurationApiService weckerConfigurationService;
    private final NativeWebRequest request;

    @Autowired
    public WeckerConfigurationApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }


    @Override
    public ResponseEntity<ModelConfiguration> addConfiguration(ModelConfiguration modelConfiguration) {
        try {
            ModelConfiguration configuration = weckerConfigurationService.persistConfiguration(modelConfiguration);
            return ResponseEntity.ok(configuration);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @Override
    public ResponseEntity<ModelConfiguration> deleteConfiguration(Long configurationId) {
        try {
            ModelConfiguration configuration = weckerConfigurationService.deleteConfiguration(configurationId);
            return ResponseEntity.ok(configuration);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @Override
    public ResponseEntity<List<ModelConfiguration>> getAllConfigurations() {
        try {
            List<ModelConfiguration> configurations = weckerConfigurationService.getAllConfigurations();
            return ResponseEntity.ok(configurations);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @Override
    public ResponseEntity<ModelConfiguration> getConfigurations(Long configurationId) {
        try {
            ModelConfiguration configuration = weckerConfigurationService.getConfigurationById(configurationId);
            return ResponseEntity.ok(configuration);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @Override
    public ResponseEntity<ModelConfiguration> updateConfiguration(Long configurationId, ModelConfiguration modelConfiguration) {
        try {
            ModelConfiguration configuration = weckerConfigurationService.updateConfiguration(configurationId, modelConfiguration);
            return ResponseEntity.ok(configuration);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
