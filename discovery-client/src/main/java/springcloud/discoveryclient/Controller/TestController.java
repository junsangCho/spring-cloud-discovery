package springcloud.discoveryclient.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springcloud.discoveryclient.client.DiscoveryHello;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    final DiscoveryHello discoveryHello;

    @GetMapping("/hello")
    public String hello(){
        System.out.println("간드아아");
        return discoveryHello.hello();
    }
}
