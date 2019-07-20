package code.up.http;

import io.micronaut.context.annotation.Property;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import javax.inject.Inject;
import java.net.URI;
import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
@Property(name = "application.url", value = "https://something.com")
class UriToAbsoluteServiceUriResolverIntegrationTest {

    @Inject
    private UriToAbsoluteServiceUriResolver uriToAbsoluteServiceUriResolver;

    @Test
    void shouldUseUserSpecifiedUri() {
        assertEquals(
            "https://something.com/test",
            uriToAbsoluteServiceUriResolver.derive(URI.create("/test")).toString()
        );
    }

}