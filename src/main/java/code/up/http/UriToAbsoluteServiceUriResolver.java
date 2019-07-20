package code.up.http;

import io.micronaut.context.annotation.Value;
import io.micronaut.http.uri.UriBuilder;
import io.micronaut.runtime.server.EmbeddedServer;
import javax.inject.Singleton;
import java.net.URI;

@Singleton
public class UriToAbsoluteServiceUriResolver {

    private final URI applicationUri;

    UriToAbsoluteServiceUriResolver(final EmbeddedServer embeddedServer, @Value("${application.url:}") final String url) {
        applicationUri = url.isEmpty() ? embeddedServer.getURI() : URI.create(url);
    }

    public URI derive(final URI uri) {
        return UriBuilder.of(applicationUri).path(uri.getPath()).build();
    }
}
