package DrinkBuddy.poc.available.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class AvailableNotFoundAdvise {

    @ResponseBody
    @ExceptionHandler(AvailableNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String buddyNotFoundHandler(AvailableNotFoundException ex) {
        return ex.getMessage();
    }
}
