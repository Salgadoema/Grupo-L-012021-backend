package ar.edu.unq.desapp.grupoL012021.backenddesappapl.webservices;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Users;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@EnableAutoConfiguration
public class UsersWebService {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public ResponseEntity<List<Users>> allUsers() {
        List<Users> foundUserss = usersService.findAll();
        if (foundUserss == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(foundUserss);
        }
    }



    @GetMapping("/byId/{id}")
    public ResponseEntity<Users> UsersById(@PathVariable("id") Integer id) {
        Users foundUsers = usersService.findById(id);
        if (foundUsers == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(foundUsers);
        }
    }

    @PostMapping("/signup")
    public Users save(@RequestBody Users user) {
        return usersService.save(user);
    }

}
