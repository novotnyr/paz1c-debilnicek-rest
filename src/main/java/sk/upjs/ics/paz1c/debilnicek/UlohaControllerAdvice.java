package sk.upjs.ics.paz1c.debilnicek;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class UlohaControllerAdvice {
    
    @ExceptionHandler(UlohaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleUlohaNotFoundException() {
        // nothing is required
    }
    
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    
    @ResponseBody
    public ApiError handleMethodArgumentTypeMismatchException() {
        return new ApiError(HttpStatus.BAD_REQUEST.value(), "Zly vstup");
    }
}
