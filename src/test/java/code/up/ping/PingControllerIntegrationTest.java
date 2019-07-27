package code.up.ping;

import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import javax.inject.Inject;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@MicronautTest
class PingControllerIntegrationTest {
    @Client("/")
    @Inject
    RxHttpClient httpClient;

    @Test
    void shouldRespondWithPong() {
        final String result = httpClient.retrieve("/ping").blockingFirst();

        assertEquals("pong", result);
    }

    @Test
    void shouldComplainIfUserDoesNotVisitPing() {
        // help me code up!
        assertFalse(true);
    }
}