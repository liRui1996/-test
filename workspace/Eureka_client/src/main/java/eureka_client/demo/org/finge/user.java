package eureka_client.demo.org.finge;

import eureka_client.demo.org.fallback.UserImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "Eureka-provider",fallbackFactory =  UserImpl.class)
public interface user {
    @GetMapping("/Find")
    public String Find();
    @GetMapping("/Findid")
    public String Findid();

}

