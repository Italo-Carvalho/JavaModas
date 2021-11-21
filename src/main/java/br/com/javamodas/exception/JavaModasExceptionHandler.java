package br.com.javamodas.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class JavaModasExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String NOT_BLANK = "NotBlank";
    private static final String LENGTH = "Length";
    private static final String NOT_NULL = "NotNull";
    private static final String PATTERN = "Pattern";
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Error> errors = generetedListError(ex.getBindingResult());
        return handleExceptionInternal(ex, errors, headers, HttpStatus.BAD_REQUEST, request);
    }


    private String manageMessageForUser(FieldError fieldError) {
        if (fieldError.getCode().equals(NOT_BLANK)){
            return fieldError.getDefaultMessage().concat(" is required");
        }
        if (fieldError.getCode().equals(LENGTH)){
            return fieldError.getDefaultMessage().concat(String.format(" must have between %s to %s characters", fieldError.getArguments()[2], fieldError.getArguments()[1]));
        }
        if (fieldError.getCode().equals(NOT_NULL)){
            return fieldError.getDefaultMessage().concat(" is required");
        }
        if (fieldError.getCode().equals(PATTERN)){
            return fieldError.getDefaultMessage().concat(" invalid format");
        }
        return fieldError.toString();
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    private ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex, WebRequest request){
        String msgUser = "Resource not found";
        String msgDev = ex.toString();
        List<Error> erros = Arrays.asList(new Error(msgUser, msgDev)); //[1]
        return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    };

    @ExceptionHandler(BusinessRuleException.class)
    public ResponseEntity<Object> handleBusinessRuleException(BusinessRuleException ex, WebRequest request){
        String msgUser = ex.getMessage();
        String msgDev = ex.getMessage();
        List<Error> erros = Arrays.asList(new Error(msgUser, msgDev)); //[1]
        return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);

    };

    @ExceptionHandler(JpaObjectRetrievalFailureException.class)
    public ResponseEntity<Object> handleJpaObjectRetrievalFailureException(JpaObjectRetrievalFailureException ex, WebRequest request){
        String msgUser = "Resource not found";
        String msgDev = ex.toString();
        List<Error> erros = Arrays.asList(new Error(msgUser, msgDev)); //[1]
        return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);

    };


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request){
        String msgUser = "Resource not found";
        String msgDev = ex.toString();
        List<Error> erros = Arrays.asList(new Error(msgUser, msgDev)); //[1]
        return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);

    };



    private List<Error> generetedListError(BindingResult bindingResult) {
        List<Error> errors = new ArrayList<Error>();
        bindingResult.getFieldErrors().forEach(fieldError -> {
            String msgUser = manageMessageForUser(fieldError);
            String mssgDev = fieldError.toString();
            errors.add(new Error(msgUser, mssgDev));
        });

        return errors;
    }


}
