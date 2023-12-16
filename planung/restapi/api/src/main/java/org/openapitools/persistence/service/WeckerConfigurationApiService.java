package org.openapitools.persistence.service;

import org.openapitools.model.ModelConfiguration;
import org.openapitools.model.PresenceLog;
import org.openapitools.persistence.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class WeckerConfigurationApiService {

    @Autowired
    private DatabaseService databaseService;

    public ModelConfiguration persistConfiguration(ModelConfiguration modelConfiguration) throws IOException {
        databaseService.persist(modelConfiguration);
        return modelConfiguration;
    }

    public ModelConfiguration deleteConfiguration(Long configurationId)  throws IOException {
        ModelConfiguration modelConfiguration = getConfigurationById(configurationId);
        databaseService.remove(modelConfiguration);
        return modelConfiguration;
    }

    public List<ModelConfiguration> getAllConfigurations()  throws IOException {
        return databaseService.query(ModelConfiguration.FIND_ALL, ModelConfiguration.class)
                .getResultList();
    }

    public ModelConfiguration getConfigurationById(Long configurationId)  throws IOException {
        return databaseService.query(ModelConfiguration.FIND_BY_ID, ModelConfiguration.class)
                .getSingleResult();
    }

    public ModelConfiguration updateConfiguration(Long configurationId, ModelConfiguration modelConfiguration)  throws IOException {
        databaseService.merge(modelConfiguration);
        return modelConfiguration;

    }
}
