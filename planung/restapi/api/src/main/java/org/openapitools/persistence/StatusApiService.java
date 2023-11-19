package org.openapitools.persistence;

import org.openapitools.model.Status;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class StatusApiService {

//todo
    public Status persistStatus(Status status) throws IOException {
        return null;
    }

    public List<Status> getAllStati() throws IOException{
        return null;
    }

    public Status getStatusById(Long statusId) throws IOException{
        return null;
    }

    public Status updateStatus(Long statusId, Status status) throws IOException{
        return null;
    }
}
