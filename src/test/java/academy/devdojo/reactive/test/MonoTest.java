package academy.devdojo.reactive.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@Slf4j
/**
 * Reactive Streams: É apenas um padrão, onde temos apenas 4 interfaces.
 *
 * 1. Asynchronous
 * 2. Non-blocking
 * 3. Backpressure
 *
 * - Publisher: Vai emitir os eventos, quem não der o subscribe, ele não emite nada (COLD)
 * - Subscriber: Quem faz um [subscribe] no publisher.
 * - Subscription: Objeto criado quando um SUBSCRIBER faz um SUBSCRIBE.
 *
 * Publisher <- (subscribe) Subscriber
 * Subscription is created
 * Publisher (onSubscribe with the subscription) -> Subscriber
 * Subscription <- (request N) Subscriber
 * Publisher -> (onNext) Subscriber
 * until:
 *  1. Publisher sends all the objects requested.
 *  2. Publisher sends all the objects it has. (onComplete) -> subscriber and subscription will be canceled.
 *  3. There is an error. (onError) -> subscriber and subscription will be canceled.
 */
public class MonoTest {

    @Test
    /**
     * Stream de [0/1]
     */
    public void monoSubscriber() {
        String name = "Yves Guilherme";

        Mono<String> mono = Mono.just(name)
                .log();

        mono.subscribe();

        log.info("----------------------------------");

        StepVerifier.create(mono)
                .expectNext(name)
                .verifyComplete();
    }
}
