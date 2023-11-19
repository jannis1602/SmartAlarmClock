package org.openapitools.persistence;

import org.openapitools.model.PresenceLog;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class WaveSensorApiService {
//todo
    public PresenceLog persistPresenceLog(PresenceLog presenceLog) throws IOException {
        return null;
    }

    public PresenceLog getPresenceLogById(Long logId) throws IOException{
        return null;
    }

    public List<PresenceLog> getAllPresenceLogs() throws IOException{
        return null;
    }
}
