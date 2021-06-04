package ar.edu.unq.desapp.grupoL012021.backenddesappapl.services;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Report;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Review;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence.ReportPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportPersistence repository;

    @Transactional
    public Report save(Report reportDAO, Review review) {

        Report report = new Report();
        report.setReporter(reportDAO.getReporter());
        report.setType(reportDAO.getType());
        report.setReview(review);
        review.addReport(report);

        return this.repository.save(report); }

    public Report findById(String id) { return this.repository.findById(id).get(); }

    public List<Report> findAll() { return this.repository.findAll(); }

    public List<Report> fromReview(Integer id) { return this.repository.fromReview(id); }
}
