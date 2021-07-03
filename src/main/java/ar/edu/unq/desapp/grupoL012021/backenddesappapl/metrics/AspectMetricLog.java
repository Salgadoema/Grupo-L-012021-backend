package ar.edu.unq.desapp.grupoL012021.backenddesappapl.metrics;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.services.UsersService;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
@Order(1)
public class AspectMetricLog {
    static Logger logger = LoggerFactory.getLogger(AspectMetricLog.class);
    private final MetricRegistry metrics = new MetricRegistry();
    private final Meter requests = metrics.meter("requests");

        String timeStart="";
        String timeEnd="";

        @Autowired(required = false)
        private HttpServletRequest request;
    private UsersService usersService;

    public AspectMetricLog() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping) || " +
                "@annotation(org.springframework.web.bind.annotation.PostMapping)")
        public void endpointMapping() {

        }

        @Before("endpointMapping()")
        public void loggerBefore() {
            //System.out.println( request.getMethod());

            timeStart = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());

            logger.info("========================================");
            logger.info("Start Request at: " +timeStart);
            logger.info("Request Method: " + request.getMethod() );
            logger.info("Request URL: "  + request.getRequestURL().toString());
        }

        @After("endpointMapping()")
        public void loggerAfter() {
           timeEnd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
           logger.info("Finish Request at: " +timeEnd);
           logger.info("========================================");



        }
    }


