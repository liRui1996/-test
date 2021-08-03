package com.example.demo.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/*异常统一处理类*/
@ControllerAdvice(basePackages = {"com.example.demo",})
public class GlobalDefaultExceptionHander {
    @ExceptionHandler({BusinessException.class})
    //如果返回json数据或者其他对象需要添加该注解
    @ResponseBody
    public ErrorInfo defaultErrorHander(HttpServletRequest req,Exception e) throws Exception{
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setMessage(e.getMessage());
        errorInfo.setUrl(req.getRequestURI());
        errorInfo.setCode(ErrorInfo.SUCCESS);
        errorInfo.setData("asd");
        return errorInfo;


    }
}
