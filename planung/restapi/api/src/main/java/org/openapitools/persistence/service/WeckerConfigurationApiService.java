package org.openapitools.persistence.service;

import org.openapitools.model.ModelConfiguration;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class WeckerConfigurationApiService {
    public ModelConfiguration persistConfiguration(ModelConfiguration modelConfiguration) throws IOException {
        return null;
    }

    public ModelConfiguration deleteConfiguration(Long configurationId)  throws IOException {
        return null;
    }

    public List<ModelConfiguration> getAllConfigurations()  throws IOException {
        return null;
    }

    public ModelConfiguration getConfigurationById(Long configurationId)  throws IOException {
        return null;
    }

    public ModelConfiguration updateConfiguration(Long configurationId, ModelConfiguration modelConfiguration)  throws IOException {
        return null;
    }
}