package com.yangyang.ReactorDemo;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Demo1 {

    @Test
    public void testDemo1() {

        //Flux<String> empty = Flux.empty();
        StepVerifier.create(Flux.just("foo","bar"))
                .expectNext("foo")
                .expectNext("bar")
                .expectComplete()
                .verify();

    }
}
