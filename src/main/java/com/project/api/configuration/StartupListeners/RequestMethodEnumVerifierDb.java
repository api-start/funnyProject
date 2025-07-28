package com.project.api.configuration.StartupListeners;

import com.project.api.model.RequestMethod;
import com.project.api.repository.interfaces.RequestMethodRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RequestMethodEnumVerifierDb implements
        ApplicationListener<ContextRefreshedEvent> {
    private RequestMethodRepository requestMethodRepository;

    public RequestMethodEnumVerifierDb(RequestMethodRepository requestMethodRepository) {
        this.requestMethodRepository = requestMethodRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        List<String> methodsNames = requestMethodRepository.findAllMethodsNames();
        RequestMethod[] methods = RequestMethod.values();
        int index = 0;

        /*ASSUMING RequestMethod.values() returns the enum in order as it says
          what this method do is find the last index of the value that exists
          and then we insert in db starting from the index because that was the last value
         */
        for (String requestMethodName: methodsNames){
            if (RequestMethod.fromName(requestMethodName) != null){
                index++;
            }
        }
        for (int i = index; i<methods.length; i++){
            requestMethodRepository.create(methods[i]);
        }
    }
}
