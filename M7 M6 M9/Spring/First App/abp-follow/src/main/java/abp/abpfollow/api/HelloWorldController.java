package abp.abpfollow.api;

import abp.abpfollow.modelo.Producto;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class HelloWorldController {


    @GetMapping("/helloWorld")
    public String getHelloWorld(){
        return "Hello World";
    }

    @GetMapping("/pathVariable/{id}")
    @ResponseBody
    public String getPathVariable(@PathVariable String id) {
        return "ID: " + id;
    }

    @PutMapping("/cr7")
    public String putCr7(String cr7) {
        return "hola" + cr7;
    }

    @PostMapping("/json")
    @ResponseBody
    public ArrayList<Producto> postJson(@RequestBody ArrayList<Producto> product) {
        return product;
    }

    @DeleteMapping("/messi")
    public String postMessi() {
        return "Hello World 4";
    }
}

