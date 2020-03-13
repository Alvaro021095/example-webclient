package webclient.entrypint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import webclient.controller.Controller;
import webclient.model.Person;

@Component
public class Handler {

    @Autowired
    Controller controller;

    public Mono<ServerResponse> getPerson(ServerRequest request){

        Mono<Person> res = controller.getPerson();

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(res, Person.class);

    }

}
