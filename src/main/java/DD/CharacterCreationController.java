package DD;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class CharacterCreationController {

    @PostMapping(path="/pccreation", consumes="text/plain")
    public String req(@RequestBody String s) {
    	System.out.println( "dope" + s);
        return "dope" + s;
    }
}