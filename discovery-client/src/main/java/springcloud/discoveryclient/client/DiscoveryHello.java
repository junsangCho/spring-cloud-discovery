package springcloud.discoveryclient.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eureka-hello")
public interface DiscoveryHello {
    @GetMapping("/test/hello")
    String hello();
}
