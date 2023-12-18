package org.openapitools.persistence.service;

import org.openapitools.model.Day;
import org.openapitools.model.ModelConfiguration;
import org.openapitools.model.ModelConfigurationDayZuordnung;
import org.openapitools.persistence.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;
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

    public ModelConfiguration deleteConfiguration(Long configurationId)  throws IOException, NoResultException {
//        List<ModelConfigurationDayZuordnung> zuordnungs = databaseService.query(ModelConfigurationDayZuordnung.FIND_BY_ALARM, ModelConfigurationDayZuordnung.class)
//                .setParameter("id", configurationId)
//                .getResultList();
//        if(zuordnungs != null && !zuordnungs.isEmpty()){
//            databaseService.remove(zuordnungs);
//
//        }

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
                .setParameter("id", configurationId)
                .getSingleResult();
    }

    public ModelConfiguration updateConfiguration(Long configurationId, ModelConfiguration modelConfiguration)  throws IOException {
        databaseService.merge(modelConfiguration);
        return modelConfiguration;

    }
}
