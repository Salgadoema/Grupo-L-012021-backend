package ar.edu.unq.desapp.grupoL012021.backenddesappapl.webservices;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Content;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.services.ContentService;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.webservices.dto.ReverseSearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class ContentWebService {

    @Autowired
    public ContentService contentService;

    @GetMapping("/api/content")
    public ResponseEntity<List<Content>> allContent() {
        List<Content> foundContent = contentService.findAll();
        return ResponseEntity.ok(foundContent);
    }

    @GetMapping("/api/content/byId/{id}")
    public ResponseEntity<Content> byContentId(Integer id) {
        Content foundContent = contentService.findById(id);
        if (foundContent == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(foundContent);
        }
    }

    @GetMapping("/api/content/filter")
    public ResponseEntity<List<Content>> findAll(@RequestBody ReverseSearchDTO reverseSearchDTO) {
        List<Content> matchingContent = contentService.findAll(reverseSearchDTO);
        return ResponseEntity.ok(matchingContent);
    }

}
