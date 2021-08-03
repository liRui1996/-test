package eureka_client.demo.org.fallback;

import eureka_client.demo.org.finge.user;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class UserImpl implements FallbackFactory<user> {

//    @Override
//    public String Find() {
//        return "熔断";
//    }
//
//    @Override
//    public String Findid() {
//        return "熔断id"+new Throwable().getMessage();
//    }

    @Override
    public user create(Throwable throwable) {
        return new user() {
            @Override
            public String Find() {
                return "熔断";
            }

            @Override
            public String Findid() {
                return "熔断id"+throwable.getMessage();
            }
        };
    }
}
