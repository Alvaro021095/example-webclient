package webclient.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import webclient.model.Person;

@Component
public class Controller {

    private WebClient webClient;

    public Controller(){
        webClient = WebClient.builder()
                .baseUrl("https://practica-webclient2.getsandbox.com:443")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public Mono<Person> getPerson(){

        return webClient.get()
                .uri("/getPerson")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Person.class);

    }

}
