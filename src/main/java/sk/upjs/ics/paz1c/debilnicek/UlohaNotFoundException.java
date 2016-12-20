package sk.upjs.ics.paz1c.debilnicek;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UlohaNotFoundException extends RuntimeException {

    public UlohaNotFoundException() {
    }

    public UlohaNotFoundException(String msg) {
        super(msg);
    }
}
