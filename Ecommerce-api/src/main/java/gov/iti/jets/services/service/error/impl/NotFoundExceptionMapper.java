package gov.iti.jets.services.service.error.impl;

import gov.iti.jets.services.dto.error.NotFoundErrorMessage;
import gov.iti.jets.services.service.error.NotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {
    @Override
    public Response toResponse( NotFoundException exception ) {
        NotFoundErrorMessage notFoundErrorMessage = new NotFoundErrorMessage(exception.getMessage(),"The object you want not found ",404);
        return Response.status( Response.Status.NOT_FOUND ).entity( notFoundErrorMessage ).build();
    }
}
