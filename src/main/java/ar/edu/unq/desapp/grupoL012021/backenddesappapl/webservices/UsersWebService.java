package ar.edu.unq.desapp.grupoL012021.backenddesappapl.webservices;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Users;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
        String token = getJWTToken(user.getPlatform());
        Users user1 = new Users();
        user1.setPlatform (user.getPlatform());
        user1.setToken(token);
        return usersService.save(user1);
    }


    private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");

		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				//.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Resenia " + token;
	}

}
