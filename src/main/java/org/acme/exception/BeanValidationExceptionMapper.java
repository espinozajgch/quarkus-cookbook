package org.acme.exception;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class BeanValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(createErrorMessage(exception))
                .type(MediaType.APPLICATION_JSON)
                .build();

    }
    private JsonArray createErrorMessage(ConstraintViolationException exc) {
        JsonArrayBuilder errors = Json.createArrayBuilder();
        for (ConstraintViolation<?> violation : exc.getConstraintViolations()) {
            errors.add(
                    Json.createObjectBuilder()
                            .add("path", violation.getPropertyPath().toString())
                            .add("message", violation.getMessage())
            );
        }
        return errors.build();
    }
}
