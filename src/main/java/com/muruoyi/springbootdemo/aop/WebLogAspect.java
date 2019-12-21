package com.muruoyi.springbootdemo.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@Aspect
@Component
public class WebLogAspect {

    /** 以 api 包下定义的所有请求为切入点 */
    @Pointcut("execution(public * com.muruoyi.springbootdemo.api..*.*(..))")
    public void webLog() {}

    /**
     * 在切点之前织入
     * @param joinPoint
     * @throws Throwable
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 打印请求相关参数
        log.info("========================================== Start ==========================================");
        // 打印请求 url
        log.info("URL            : {}", request.getRequestURL().toString());
        // 打印 Http method
        log.info("HTTP Method    : {}", request.getMethod());
        // 打印调用 controller 的全路径以及执行方法
        log.info("Class Method   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        // 打印请求的 IP
        log.info("IP             : {}", request.getRemoteAddr());
        // 打印请求入参
        log.info("Request Args   : {}", JSON.toJSON(joinPoint.getArgs()));
        log.info("===========================================================================================");
    }

    /**
     * 在切点之后织入
     * @throws Throwable
     */
    @After("webLog()")
    public void doAfter() throws Throwable {
        log.info("===========================================================================================");
        // 每个请求之间空一行
        log.info("");
    }

    /**
     * 环绕
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("=========================================== End ===========================================");
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        // 打印出参
        log.info("Response Args  : {}", JSON.toJSON(result));
        // 执行耗时
        log.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
        return result;
    }

}
