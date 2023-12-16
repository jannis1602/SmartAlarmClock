package org.openapitools.persistence.service;

import org.openapitools.model.PresenceLog;
import org.openapitools.model.Status;
import org.openapitools.persistence.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class WaveSensorApiService {
    @Autowired
    private DatabaseService databaseService;
    public PresenceLog persistPresenceLog(PresenceLog presenceLog) throws IOException {
        databaseService.persist(presenceLog);
        return presenceLog;
    }

    public PresenceLog getPresenceLogById(Long logId) throws IOException{
        return databaseService.query(PresenceLog.FIND_BY_ID, PresenceLog.class)
                .setParameter("id", logId)
                .getSingleResult();
    }

    public List<PresenceLog> getAllPresenceLogs() throws IOException{
        return databaseService.query(PresenceLog.FIND_ALL, PresenceLog.class)
                .getResultList();
    }
}
