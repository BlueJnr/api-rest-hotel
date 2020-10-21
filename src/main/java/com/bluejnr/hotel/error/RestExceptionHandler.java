package com.bluejnr.hotel.error;

import com.bluejnr.hotel.exception.RestrictionException;
import com.bluejnr.hotel.exception.TransitionException;
import com.bluejnr.hotel.model.api.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(RestrictionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBadRequest(RestrictionException e){
        return new ErrorResponse(400, e.getMessage());
    }

    @ExceptionHandler(TransitionException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse handleForbidden(TransitionException e){
        return new ErrorResponse(403, e.getMessage());
    }
}
