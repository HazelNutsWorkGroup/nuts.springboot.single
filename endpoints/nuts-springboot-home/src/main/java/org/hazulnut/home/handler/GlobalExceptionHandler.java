package org.hazulnut.home.handler;

import org.hazulnut.home.model.RResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * Handle other types of exceptions in RResponse.
     *
     * @param exception the exception
     * @return the RResponse
     */
    @ExceptionHandler(Exception.class)
    public RResponse jsonErrorHandler(Exception exception) {
        logger.error("[Exception]:{}", exception.getMessage());
        return RResponse.ofException(exception);
    }
}
