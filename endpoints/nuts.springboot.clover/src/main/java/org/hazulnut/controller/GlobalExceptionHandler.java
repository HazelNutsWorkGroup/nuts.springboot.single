package org.hazulnut.controller;

import org.hazulnut.home.model.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理.
 *
 * <p>统一的异常处理handler
 *
 * @author <a href="https://blog.csdn.net/yidichaxiang" target="_blank">Sleeber</a>
 * @since 1.3.0
 *
 * <p><b>Note:</b>
 * <p>2020/7/23 22:56: created.<br>
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Json error handler api response.
     *
     * @param exception the exception
     * @return the api response
     */
    @ExceptionHandler(value = Exception.class)
    public ApiResponse jsonErrorHandler(Exception exception) {
        logger.error("[Exception]:{}", exception.getMessage());
        return ApiResponse.ofException(exception);
    }
}
