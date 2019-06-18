package top.keepmoving.kmweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.keepmoving.kmweb.web.quartz.exception.ServiceException;

import javax.sql.rowset.serial.SerialException;

/**
 * <p>@Author:Vince
 * <p>@Date:2019-06-18
 * <p>@Description:
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/exceptionHandler")
    public String exceptionHandler() throws ServiceException {

        if (1 == 1) {
            throw new ServiceException("Page Not Found 123");
        }

        return "/";
    }
}
