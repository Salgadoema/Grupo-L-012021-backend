package ar.edu.unq.desapp.grupoL012021.backenddesappapl.metrics;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.ProceedingJoinPoint;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import java.util.Date;

@Aspect
@Component
@Order(1)
public class WebServicesExecutionLog {
    static Logger logger = LoggerFactory.getLogger(WebServicesExecutionLog.class);
    private ObjectMapper mapper = new ObjectMapper();

    @Around("execution(* ar.edu.unq.desapp.grupoL012021.backenddesappapl.webservices..*(..))")


    public Object webServiceLog(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();




        String[] argNames=methodSignature.getParameterNames();
        Object[] objects=joinPoint.getArgs();
        String methodName= joinPoint.getSignature().getName();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String platform=mapper.writeValueAsString(auth.getPrincipal());
        String arguments="";

        for (int i = 0; i < argNames.length; i++) {
            arguments+= argNames[i] + ": " + mapper.writeValueAsString(objects[i]) + ", ";
        }


        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
//  logger.info("METHOD: " + joinPoint.getSignature().getName());
        //  logger.info("ARGUMENTS: " + arguments);

     //  logger.info ("USER CREDENTIAL: " +mapper.writeValueAsString(auth.getPrincipal()));
      //  logger.info("EXECUTED IN: " + executionTime + " ms.");
        logger.info("========================================");
        logger.info(new Date().toString());
        logger.info("========================================");
        logger.info("EXECUTING BY: "+ platform );
        logger.info("EXECUTIION TIME: "+ executionTime + " ms");
        logger.info("METHOD EXECUTED: [ {} ] WITH ARGUMENTS: {} ", methodName, arguments);



        return proceed;
    }

}
