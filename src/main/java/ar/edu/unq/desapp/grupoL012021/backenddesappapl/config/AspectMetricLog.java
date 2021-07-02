package ar.edu.unq.desapp.grupoL012021.backenddesappapl.config;

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
import org.springframework.beans.factory.annotation.Autowired;
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
    public class AspectMetricLog {
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

            System.out.println("*************************************************************************");
            System.out.println(timeStart);
            System.out.println("Request for endpoint " + request.getMethod() + " - " + request.getRequestURL().toString() + " started.");
        }

        @After("endpointMapping()")
        public void loggerAfter() {
           timeEnd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
            System.out.println("*************************************************************************");
            System.out.println(timeEnd);
            System.out.println("Request for endpoint " + request.getMethod() + " - " + request.getRequestURL().toString() + " finished.");
            System.out.println(timeEnd);
            qtyLog++;

            System.out.println(qtyLog);


            ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics)
                    .convertRatesTo(TimeUnit.SECONDS)
                    .convertDurationsTo(TimeUnit.MILLISECONDS)
                    .build();
            reporter.start(10, TimeUnit.SECONDS);

        }
    }


