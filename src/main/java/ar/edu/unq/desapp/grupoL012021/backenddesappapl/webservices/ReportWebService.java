package ar.edu.unq.desapp.grupoL012021.backenddesappapl.webservices;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.PublicReview;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Report;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.services.PublicReviewService;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class ReportWebService {

    @Autowired
    private ReportService reportService;

    @Autowired
    private PublicReviewService reviewService;

    @GetMapping("/api/reports")
    public List<Report> allReports() {
        return reportService.findAll();
    }

    @GetMapping("api/reports/from/{id}")
    public ResponseEntity<List<Report>> reportsFromReview(@PathVariable("id") Integer id) {
        List<Report> reports = reportService.fromReview(id);
        return ResponseEntity.ok(reports);
    }

    @PostMapping("api/reports/add/{id}")
    public ResponseEntity<Report> addReportTo(@PathVariable("id") Integer id, @RequestBody Report reportDAO) {
        PublicReview review = reviewService.findById(id);
        if(review == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            Report report = new Report();
            report.setReporter(reportDAO.getReporter());
            report.setType(reportDAO.getType());
            report.setReview(review);
            review.addReport(report);
            reportService.save(report);
            return ResponseEntity.ok(report);
        }
    }

}
