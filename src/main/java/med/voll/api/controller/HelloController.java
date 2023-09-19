package med.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello") //ruta http
public class HelloController {
    
    @GetMapping //mapeo de la ruta
    public String helloWorld(){
        return "Hello Worlder";
    }

}
