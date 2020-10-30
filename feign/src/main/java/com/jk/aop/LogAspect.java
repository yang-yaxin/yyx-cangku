package com.jk.aop;

import com.alibaba.fastjson.JSONObject;
import com.jk.entity.LogBean;
import com.jk.service.LogSenderService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Autowired
    private LogSenderService logSenderService;

    @Pointcut("execution(* com.jk.controller.*.*(..))")
    public void logCut(){}

    @AfterReturning(pointcut="logCut()",returning="obj")
    public void saveLog(JoinPoint joinPoint, Object obj){
        String className=joinPoint.getTarget().getClass().getSimpleName();
        String methodName=joinPoint.getSignature().getName();
        Object[] args=joinPoint.getArgs();
        StringBuffer sb=new StringBuffer();
        for (int i=0;i<args.length;i++) {
          sb.append("第"+i+"个参数："+args[i]+"\r\n");
        }
        LogBean logBean=new LogBean();
        logBean.setMethodName(methodName);
        logBean.setClassName(className);
        logBean.setResponseParam(obj==null?"":obj.toString());
        logBean.setRequestParam(sb.toString());
        //
        String logJson= JSONObject.toJSONString(logBean);
        //存到消息队列
        logSenderService.send(logJson);
    }

}
