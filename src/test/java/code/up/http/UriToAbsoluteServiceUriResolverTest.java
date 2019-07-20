package code.up.http;

import io.micronaut.runtime.server.EmbeddedServer;
import java.net.URI;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class UriToAbsoluteServiceUriResolverTest {
    void shouldResolveUsingEmbeddedServerIfNoUserDefinedUri() {
        // assemble
        final EmbeddedServer embeddedServer = mock(EmbeddedServer.class);
        doReturn(8080).when(embeddedServer).getPort();
        doReturn("localhost").when(embeddedServer).getHost();
        doReturn("http").when(embeddedServer).getScheme();
        // act
        final URI derived = new UriToAbsoluteServiceUriResolver(embeddedServer, "").derive(URI.create("/a/test"));
        // assert
        assertEquals("http://localhost:8080/a/test", derived.toString());
    }

    void shouldResolveUsingUserDefinedUri() {
        // assemble
        final EmbeddedServer embeddedServer = mock(EmbeddedServer.class);
        // act
        final URI derived = new UriToAbsoluteServiceUriResolver(embeddedServer, "http://test.com")
            .derive(URI.create("/a/test"));
        // assert
        assertEquals("http://test.com/a/test", derived.toString());
    }
}