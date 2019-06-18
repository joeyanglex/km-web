package top.keepmoving.kmweb.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import top.keepmoving.kmweb.web.quartz.exception.ServiceException;

/**
 * <p>@Author:Vince
 * <p>@Date:2019-06-05
 * <p>@Description:
 */
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public final String handleServiceException(ServiceException ex, WebRequest request) {
        return "error/404";
    }

}
