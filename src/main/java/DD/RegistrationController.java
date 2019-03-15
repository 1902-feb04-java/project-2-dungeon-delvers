package DD;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class RegistrationController {

    @PostMapping(path="/register2", consumes="text/plain")
    public String index2(@RequestBody String s) {
    	System.out.println("POSTed at register2: " + s);
        return "POSTed at register2: " + s;
    }
    
    @PostMapping(path="/registerAccount", consumes="application/json")
    public String acc(@RequestBody Object o) {
    	System.out.println(o.toString());
    	return o.toString();
    }

}