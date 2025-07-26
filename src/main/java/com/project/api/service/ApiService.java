package com.project.api.service;

import com.project.api.model.Api;
import com.project.api.model.Category;
import com.project.api.repository.ApiDataAccessService;
import com.project.api.service.dto.CreateApiRequest;
import com.project.api.service.exception.ApiAlreadyCreatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApiService {
    private ApiDataAccessService apiDataAccessService;

    @Autowired
    public ApiService(ApiDataAccessService apiDataAccessService) {
        this.apiDataAccessService = apiDataAccessService;
    }

    @Transactional
    public String createApi(UUID accountId, CreateApiRequest createApiRequest){
        Optional<Api> optionalApi = apiDataAccessService.findByName(createApiRequest.getName());
        if (optionalApi.isPresent()){
            throw new ApiAlreadyCreatedException("The api already exists");
        }
        UUID id = UUID.randomUUID();
        Api api = Api.createNew(id, createApiRequest.getName(), createApiRequest.getUrlBase(),
                createApiRequest.getDescription(),createApiRequest.getVersion(),
                LocalDate.now(),LocalDate.now(), accountId, createApiRequest.getCategory());
        apiDataAccessService.save(api);
        return api.getId().toString();
    }

    public Api getApi(String id){
        Optional<Api> optionalApi = apiDataAccessService.findById(UUID.fromString(id));
        return optionalApi.orElse(null); // TODO: SHOULD HAVE DTOS FOR OBJECT RETRIEVALS
    }


}
