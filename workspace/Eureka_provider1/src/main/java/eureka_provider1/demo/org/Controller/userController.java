package eureka_provider1.demo.org.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {
    @GetMapping("/Find")
    public String name(){
        return "success";
    }
    @GetMapping("/Findid/{id}")
    public String nameid(@PathVariable(value = "id") int d) throws InterruptedException {

        if(d==2){
            throw new RuntimeException();
        }
        //Thread.sleep(2000L);
        return "lirui";

    }
}
