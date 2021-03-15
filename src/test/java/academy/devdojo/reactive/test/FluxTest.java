package academy.devdojo.reactive.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@Slf4j
public class FluxTest {

    @Test
    public void fluxSubscriber() {
        Flux<String> fluxString = Flux.just("Yves", "Guilherme", "DevDojo", "Academy")
                .log();

        StepVerifier.create(fluxString)
                .expectNext("Yves", "Guilherme", "DevDojo", "Academy")
                .verifyComplete();
    }

    @Test
    public void fluxSubscriberNumbers() {
        Flux<Integer> fluxInteger = Flux.range(1, 5)
                .log();

        fluxInteger.subscribe(i -> log.info("Number {}", i));

        log.info("-------------------------------------------");

        StepVerifier.create(fluxInteger)
                .expectNext(1, 2, 3, 4, 5)
                .verifyComplete();
    }
}
