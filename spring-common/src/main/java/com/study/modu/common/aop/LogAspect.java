package com.study.modu.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Explain:web工程的日志切面
 * </p >
 *
 * @author wangjunming
 * @since 2019-12-30 13:30
 */
@Component
@Aspect
public class LogAspect {

    /**
     * 日志切点
     *
     * @return void
     * @author wangjunming
     * @since 2019/12/30 14:43
     */
    @Pointcut("execution(public * com.study.modu.*.controller..*Controller.*(..))")
    public void controllerLog() {
    }

    /**
     * 环绕通知
     *
     * @param joinPoint:切点
     * @return java.lang.Object
     * @author wangjunming
     * @since 2019/12/30 14:44
     */
    @Around("controllerLog()")
    public Object doAroundFeignClient(ProceedingJoinPoint joinPoint) throws Throwable {
        return joinPoint.proceed();

    }

}
