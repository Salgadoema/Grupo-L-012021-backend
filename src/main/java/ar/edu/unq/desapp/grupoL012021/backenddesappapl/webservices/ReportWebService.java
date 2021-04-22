package ar.edu.unq.desapp.grupoL012021.backenddesappapl.webservices;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Report;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class ReportWebService {

    @Autowired
    private ReportService reportService;

    @GetMapping("/api/reports")
    public List<Report> allReports() {
        List<Report> reports = reportService.findAll();
        return reports;
    }
}
