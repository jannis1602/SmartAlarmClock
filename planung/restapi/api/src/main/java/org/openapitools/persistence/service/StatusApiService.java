package org.openapitools.persistence.service;

import org.openapitools.model.Status;
import org.openapitools.persistence.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class StatusApiService {
    @Autowired
    private DatabaseService databaseService;
    public Status persistStatus(Status status) throws IOException {
        databaseService.persist(status);
        return status;
    }

    public List<Status> getAllStati() throws IOException{
        return databaseService.query(Status.FIND_ALL, Status.class)
                .getResultList();
    }

    public Status getStatusById(Long statusId) throws IOException{
        return databaseService.find(Status.class, statusId);
    }

    public Status updateStatus(Long statusId, Status status) throws IOException{
        databaseService.merge(status);
        return status;
    }
}
