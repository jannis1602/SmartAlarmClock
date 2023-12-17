package org.openapitools.api;


import org.openapitools.json.JSONDay;
import org.openapitools.json.JSONModelConfiguration;
import org.openapitools.model.Day;
import org.openapitools.model.ModelConfiguration;
import org.openapitools.model.ModelConfigurationDayZuordnung;
import org.openapitools.persistence.service.WeckerConfigurationApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import javax.annotation.Generated;
import javax.persistence.NoResultException;
import java.io.IOException;
import java.util.ArrayList;
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
    public ResponseEntity<JSONModelConfiguration> addConfiguration(JSONModelConfiguration jsonDTO) {
        try {
            ModelConfiguration configuration =  translateJsonDtoToEntity(jsonDTO);

            configuration = weckerConfigurationService.persistConfiguration(configuration);

            jsonDTO.setId(configuration.getId());
            return ResponseEntity.ok(jsonDTO);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @Override
    public ResponseEntity<JSONModelConfiguration> deleteConfiguration(Long configurationId) {
        try {
            ModelConfiguration configuration = weckerConfigurationService.deleteConfiguration(configurationId);
            return ResponseEntity.ok(translateEntityToJsonDto(configuration));
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (NoResultException e){
            return ResponseEntity.noContent().build();
        }
    }

    @Override
    public ResponseEntity<List<JSONModelConfiguration>> getAllConfigurations() {
        try {
            List<ModelConfiguration> configurations = weckerConfigurationService.getAllConfigurations();

            List<JSONModelConfiguration> jsonModelConfigurations = new ArrayList<>();
            for(ModelConfiguration configuration : configurations){
                jsonModelConfigurations.add(translateEntityToJsonDto(configuration));
            }
            return ResponseEntity.ok(jsonModelConfigurations);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @Override
    public ResponseEntity<JSONModelConfiguration> getConfigurations(Long configurationId) {
        try {
            ModelConfiguration configuration = weckerConfigurationService.getConfigurationById(configurationId);
            return ResponseEntity.ok(translateEntityToJsonDto(configuration));
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @Override
    public ResponseEntity<JSONModelConfiguration> updateConfiguration(Long configurationId, JSONModelConfiguration jsonModelConfiguration) {
        try {

            ModelConfiguration configuration = translateJsonDtoToEntity(jsonModelConfiguration);
            configuration.setId(configurationId);
            configuration = weckerConfigurationService.updateConfiguration(configurationId, configuration);
            return ResponseEntity.ok(translateEntityToJsonDto(configuration));
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    private JSONModelConfiguration translateEntityToJsonDto(ModelConfiguration modelConfiguration){
        JSONModelConfiguration jsonDTO = new JSONModelConfiguration();

        jsonDTO.setActive(modelConfiguration.getActive());
        jsonDTO.setAlarmDate(modelConfiguration.getAlarmDate());
        jsonDTO.setAlarmTime(modelConfiguration.getAlarmTime());
        jsonDTO.setId(modelConfiguration.getId());

        List<JSONDay> jsonDays = new ArrayList<>();
        JSONDay jsonDay;
        for (ModelConfigurationDayZuordnung zuordnung : modelConfiguration.getDays()) {
            jsonDay = new JSONDay();
            jsonDay.setId(zuordnung.getId().getDay().getId());
            jsonDay.setName(zuordnung.getId().getDay().getName());
            jsonDay.setActive(zuordnung.getActive());

            jsonDays.add(jsonDay);
        }

        jsonDTO.setDays(jsonDays);
        return jsonDTO;
    }
    private ModelConfiguration translateJsonDtoToEntity(JSONModelConfiguration jsonDTO){
        ModelConfiguration configuration = new ModelConfiguration();
        configuration.setActive(jsonDTO.getActive());
        configuration.setAlarmDate(jsonDTO.getAlarmDate());
        configuration.setAlarmTime(jsonDTO.getAlarmTime());
        configuration.setId(jsonDTO.getId());


        if (jsonDTO.getDays() == null)
            return configuration;
        List<ModelConfigurationDayZuordnung> zuordnungs = new ArrayList<>();
        ModelConfigurationDayZuordnung zuordnung;
        for (JSONDay jsonDay : jsonDTO.getDays()) {
            zuordnung = new ModelConfigurationDayZuordnung();
            zuordnung.setId(new ModelConfigurationDayZuordnung.KeyAlarmDay());

            zuordnung.getId().setDay(translateJsonDay(jsonDay));
            zuordnung.getId().setModelConfiguration(configuration);
            zuordnung.setActive(jsonDay.getActive());

            zuordnungs.add(zuordnung);
        }

        configuration.setDays(zuordnungs);
        return configuration;
    }
    private Day translateJsonDay(JSONDay jsonDay){
        Day day = new Day();
        day.setId(jsonDay.getId());
        day.setName(jsonDay.getName());

        return day;
    }
}
