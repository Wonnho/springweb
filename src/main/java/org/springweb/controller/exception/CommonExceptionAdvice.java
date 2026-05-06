package org.springweb.controller.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.lang.reflect.Array;
import java.util.Arrays;

@ControllerAdvice
@Log4j2
public class CommonExceptionAdvice {

//    @ResponseBody
//    @ExceptionHandler(Exception.class)
//    public String exceptNumber(NumberFormatException numberFormatException) {
//        log.error("--------------------------------");
//       log.error(numberFormatException);
//       return "NUMBER FORMAT EXCEPTION";
//    }
    @ResponseBody
    @ExceptionHandler(NumberFormatException.class)
    public String exceptionCommon(Exception exception) {
        log.error("============================");
        log.error(exception.getMessage());


        StringBuffer buffer=new StringBuffer("<ul>");

        buffer.append("<li>" + exception.getMessage()+"</li>");
        Arrays.stream(exception.getStackTrace()).forEach(stackTraceElement -> {
            buffer.append("<li>"+stackTraceElement+"</li>");
        });
        buffer.append("</ul>");

        return buffer.toString();
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public String notFound() {
        return "custom404";
    }

}
