package code.up.ping;

import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import javax.inject.Inject;
import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class PingControllerTest {
    @Client("/")
    @Inject
    RxHttpClient httpClient;

    @Test
    void shouldRespondWithPong() {
        final String result = httpClient.retrieve("/ping").blockingFirst();

        assertEquals("pong", result);
    }
}