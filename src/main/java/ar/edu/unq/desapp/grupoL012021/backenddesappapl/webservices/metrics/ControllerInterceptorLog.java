package ar.edu.unq.desapp.grupoL012021.backenddesappapl.webservices.metrics;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Interceptor
 */
@Aspect
@Component
@Order(2)
public class ControllerInterceptorLog {

    static Logger logger = LoggerFactory.getLogger(ControllerInterceptorLog.class);
    ThreadLocal<Long> startTime = new ThreadLocal<>();// start time
    private ObjectMapper mapper = new ObjectMapper();
    ThreadLocal<Map<String, Long >> numberOfTimes = new ThreadLocal<>();


    ThreadLocal<Map<String, Long >> totalTimeConsuming = new ThreadLocal<>();


    /**
     * Define an entry point. Explain:
     *
     * ~ The first * represents any modifier and any return value.
     * ~ The second * is defined in a web package or a sub-package
     * ~ the third * Any method ~ .. Matches any number of parameters.
     */
    static final String pCutStr = "execution(* ar.edu.unq.desapp.grupoL012021.backenddesappapl.webservices.*..*(..))";

    @Pointcut(value = pCutStr)
    public void logPointcut() {
    }

    @Around("logPointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {


        //Initialize once
        if(numberOfTimes.get() ==null ){numberOfTimes.set(new HashMap<>());}

        if(totalTimeConsuming.get() == null){totalTimeConsuming.set(new HashMap<>());}

        long start = System.currentTimeMillis();
        try {
            Object result = joinPoint.proceed();
            if(result==null){
                return null;
            }
            long end = System.currentTimeMillis();

            logger.info("======================================");
            String tragetClassName = joinPoint.getSignature().getDeclaringTypeName();
            String MethodName = joinPoint.getSignature().getName();

            Object[] args = joinPoint.getArgs();// parameters
            int argsSize = args.length;
            String argsTypes = "";
            String typeStr = joinPoint.getSignature().getDeclaringType().toString().split(" ")[0];

            String returnType = joinPoint.getSignature().toString().split(" ")[0];

            logger.info("Class/Interface:" + tragetClassName + "(" + typeStr + ")");
            logger.info("Method:" + MethodName);
            logger.info("Number of parameters:" + argsSize);
            logger.info("Return Type:" + returnType);
            if (argsSize > 0) {
                for (Object object : args) {
                    argsTypes += object.getClass().getTypeName().toString() + " ";
                }
                logger.info("Parameter type:" + argsTypes);
            }

            Long total = end - start;
            logger.info("Time-consuming: "+ total +" ms!");

            if(numberOfTimes.get().containsKey(MethodName)){
                Long count = numberOfTimes.get().get(MethodName);
                numberOfTimes.get().remove(MethodName);//Remove first, increase
                numberOfTimes.get().put(MethodName, count+1);

                count = totalTimeConsuming.get().get(MethodName);
                totalTimeConsuming.get().remove(MethodName);
                totalTimeConsuming.get().put(MethodName, count+total);
            }else{

                numberOfTimes.get().put(MethodName, 1L);
                totalTimeConsuming.get().put(MethodName, total);
            }

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String platform=mapper.writeValueAsString(auth.getPrincipal());


            Object proceed = joinPoint.proceed();



            logger.info("========================================");
            logger.info("EXECUTING BY: "+ platform );
            logger.info("========================================");

            return result;

        } catch (Throwable e) {
            long end = System.currentTimeMillis();
            logger.info("====around " + joinPoint + "\tUse time : " + (end - start) + " ms with exception : "
                    + e.getMessage());
            throw e;
        }

    }


}