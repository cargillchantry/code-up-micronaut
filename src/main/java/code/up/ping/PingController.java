package code.up.ping;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller
public class PingController {
    @Get("{ping}")
    String ping(final String ping) {
        if(ping.toLowerCase().equals("ping")) {
            return "pong";
        }
        return "what";
    }
}
