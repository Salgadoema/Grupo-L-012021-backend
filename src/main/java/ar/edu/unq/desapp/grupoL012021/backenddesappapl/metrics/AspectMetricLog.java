package ar.edu.unq.desapp.grupoL012021.backenddesappapl.metrics;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Users;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence.ContentPersistence;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.services.UsersService;
import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import springfox.documentation.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codahale.metrics.MetricRegistry.name;

@Aspect
@Component
@Order(2)
public class AspectMetricLog {
    static Logger logger = LoggerFactory.getLogger(WebServicesExecutionLog.class);
    private final MetricRegistry metrics = new MetricRegistry();
    private final Meter requests = metrics.meter("requests");
         Integer qtyLog=0;
        String timeStart="";
        String timeEnd="";




        @Autowired(required = false)
        private HttpServletRequest request;
    private UsersService usersService;
        @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping) || " +
                "@annotation(org.springframework.web.bind.annotation.PostMapping)")
        public void endpointMapping() {

        }

        @Before("endpointMapping()")
        public void loggerBefore() {
            System.out.println( request.getMethod());

            timeStart = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());

            logger.info("========================================");
            logger.info(timeStart);
            logger.info("Request for endpoint " + request.getMethod() + " - " + request.getRequestURL().toString() + " started.");
        }

        @After("endpointMapping()")
        public void loggerAfter() {
           timeEnd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
            logger.info("========================================");
            logger.info(timeEnd);
            logger.info("Request for endpoint " + request.getMethod() + " - " + request.getRequestURL().toString() + " finished.");
            logger.info(timeEnd);
            qtyLog++;

            logger.info("Qty of Methods " + String.valueOf(qtyLog));



        }
    }


