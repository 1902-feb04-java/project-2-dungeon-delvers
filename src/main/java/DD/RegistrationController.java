package DD;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class RegistrationController {

    @RequestMapping("/register")
    public ResponseEntity<String> index() {
    	System.out.println("GET at register");
        return ResponseEntity.ok("Greetings from Spring Boot!");
    }

}