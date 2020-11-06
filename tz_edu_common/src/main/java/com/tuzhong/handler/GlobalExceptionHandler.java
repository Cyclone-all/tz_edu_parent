package com.tuzhong.handler;


import com.tuzhong.response.RetVal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ProjectName: tz_edu_parent
 * @Package: com.tuzhong.handler
 * @Author: WangYongShuai
 * @Description: 全局的异常处理器
 * @Date: 2020/11/2 16:45
 * @Version: 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public RetVal error(Exception e) {
        return RetVal.error().message("出现全局异常");
    }

}
