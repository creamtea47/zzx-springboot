package com.fjcpc.zzx.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/*** 全局异常类
 * @author xiaolu LuAng
 * @create 2022-05-31 23:21
 **/
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /*
     * 缺少请求参数异常
     * @param ex HttpMessageNotReadableException
     * @return
     * */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public JsonResult handleHttpMessageNotReadableException(
            MissingServletRequestParameterException ex) {
        LOGGER.error("全局异常捕捉 => 缺少请求参数，{}", ex.getMessage());
        return JsonResult.error(CodeMsg.PARAMETER_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handleTypeMismatchException(NullPointerException nullPointerException) {
        LOGGER.error("全局异常捕捉 => 空指针异常,{}", nullPointerException.getMessage());
        return JsonResult.error(CodeMsg.NULL_POINTER_EXCEPTION_ERROR);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handleUnexpectedServer(Exception exception) {
        LOGGER.error("全局异常捕捉 => 系统异常{}", exception.getMessage());
        return JsonResult.error(CodeMsg.EXCEPTION_ERROR);
    }
}