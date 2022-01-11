package com.eg;

import java.time.Duration;

import reactor.core.publisher.Flux;

public class FluxIntervalEg {
public static void main(String[] args) throws InterruptedException {
	Flux<String> flux =
			Flux.interval(Duration.ofMillis(250))
			    .map(input -> {
			        if (input < 3) return "tick " + input;
			        throw new RuntimeException("boom");
			    })
			    .onErrorReturn("Error occurreddd");

			flux.subscribe(System.out::println);
			Thread.sleep(2100);
}
}
