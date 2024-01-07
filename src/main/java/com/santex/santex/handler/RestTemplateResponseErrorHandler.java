package com.santex.santex.handler;

import com.santex.santex.exception.SantexExceptionInternalServer;
import com.santex.santex.exception.SantexExceptionNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

public class RestTemplateResponseErrorHandler implements ResponseErrorHandler{

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if(response.getStatusCode() == HttpStatus.NOT_FOUND)
            throw new SantexExceptionNotFound("Not data found for the provided input data");
        else if(response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR)
            throw new SantexExceptionInternalServer("An internal error occurred");
    }

}
