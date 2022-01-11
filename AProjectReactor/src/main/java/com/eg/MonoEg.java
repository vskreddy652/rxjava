package com.eg;

import reactor.core.publisher.Mono;

public class MonoEg {
	public static void main(String[] args) {
	    //Creates a new String Mono which emits "Hi there!"
	    Mono<String> message = Mono.just("Hi there!");
	    message.subscribe(System.out::println);
	}
}
