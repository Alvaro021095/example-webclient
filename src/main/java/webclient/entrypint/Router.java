package webclient.entrypint;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class Router {

    @Bean
    public RouterFunction<ServerResponse> routerPerson(Handler handler){

        return route(GET("/getPerson")
        .and(accept(MediaType.APPLICATION_JSON))
        .and(contentType(MediaType.APPLICATION_JSON)),handler::getPerson);

    }

}
