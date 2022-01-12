package rs.rfc;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@OpenAPIDefinition(
        servers = {
                @Server(url = "http://localhost:8080")
        },
        info = @Info(title = "Forms", description = "Applications managing forms and their templates", version = "1.0")
)
@ApplicationPath("/")
public class App extends Application {
}
