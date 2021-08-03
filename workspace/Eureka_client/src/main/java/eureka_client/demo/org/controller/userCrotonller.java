package eureka_client.demo.org.controller;


import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import eureka_client.demo.org.finge.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@DefaultProperties(defaultFallback = "getAllProductFallBack")
public class userCrotonller {

    @Autowired
    user user1;
    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/hi")
    public String hi(){
        return user1.Find();
    }
    @GetMapping("/bye/{id}")
    @HystrixCommand(commandProperties = {

            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "30")

    })
    public String bye(@PathVariable(value = "id") int d){
        String uri="http://Eureka-provider/Findid/"+d;
        String vos = restTemplate.getForObject(uri, String.class);
        return vos;
    }
    public String getAllProductFallBack(){
        return "系统繁忙，请稍后重试";
    }
}
