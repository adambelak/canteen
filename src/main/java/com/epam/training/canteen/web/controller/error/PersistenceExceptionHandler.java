package com.epam.training.canteen.web.controller.error;

import com.epam.training.canteen.exception.ErrorResource;
import com.epam.training.canteen.exception.FieldErrorResource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.PersistenceException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Optional;

@ControllerAdvice("com.epam.training.canteen")
public class PersistenceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({PersistenceException.class, DataIntegrityViolationException.class})
    protected ResponseEntity<Object> handlePersistenceException(Exception exception, WebRequest request) {
        Optional<String> fieldName = getUniqueFieldName(exception);
        ErrorResource error = (fieldName.isPresent())
                ? getConstraintErrorResource(exception, fieldName.get())
                : getGeneralErrorResource(exception);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(exception, error, headers, HttpStatus.UNPROCESSABLE_ENTITY, request);
    }

    private ErrorResource getConstraintErrorResource(Exception exception, String field) {
        ErrorResource error = new ErrorResource("ConstraintViolationException", exception.getMessage());
        FieldErrorResource fieldError = new FieldErrorResource();
        fieldError.setField(field);
        fieldError.setCode("422");
        fieldError.setMessage("This " + field + " has already been taken. Please pick another " + field + ".");
        error.setFieldErrors(Arrays.asList(fieldError));
        return error;
    }

    private ErrorResource getGeneralErrorResource(Exception exception) {
        return new ErrorResource("409", exception.getMessage());
    }

    private Optional<String> getUniqueFieldName(Exception exception) {
        return Arrays.stream(getStackTrace(exception).split("\n"))
                .filter(line -> line.contains("integrity constraint violation"))
                .map(line -> getFieldName(line))
                .findFirst();
    }

    private String getFieldName(String line) {
        String result = line.substring(line.lastIndexOf(";") + 2, line.lastIndexOf(" table:"));
        return result.substring(result.lastIndexOf("_") + 1).toLowerCase();
    }

    private String getStackTrace(Exception exception) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        exception.printStackTrace(printWriter);
        return stringWriter.toString();
    }

}
