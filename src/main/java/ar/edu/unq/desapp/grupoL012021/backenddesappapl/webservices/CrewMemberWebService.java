package ar.edu.unq.desapp.grupoL012021.backenddesappapl.webservices;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.CrewMember;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.services.CrewMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actors")
@EnableAutoConfiguration
public class CrewMemberWebService {

    @Autowired
    private CrewMemberService crewMemberService;

    @GetMapping
    public ResponseEntity<List<CrewMember>> allCrewMembers() {
        List<CrewMember> foundCrew = crewMemberService.findAll();
        if (foundCrew == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(foundCrew);
        }
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<CrewMember> crewMemberById(@PathVariable("id") Integer id) {
        CrewMember foundCrewMember = crewMemberService.findById(id);
        if (foundCrewMember == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(foundCrewMember);
        }
    }

    @PostMapping("")
    public CrewMember save(@RequestBody CrewMember crewMember) {
        return crewMemberService.save(crewMember);
    }

}
