package top.keepmoving.kmweb.web.quartz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * <p>@Author:Vince
 * <p>@Date:2019-05-23
 * <p>@Description:
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Page Not Found")
public class ServiceException extends Exception {

    public ServiceException(String msg, Exception e) {
        super(msg + "\n" + e.getMessage());
    }

    public ServiceException(String msg) {
        super(msg);
    }
}
