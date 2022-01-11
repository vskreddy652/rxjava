package com.eg;

import java.time.Duration;
import java.time.Instant;

import reactor.core.publisher.Flux;

public class FluxDelayEg {
	public static void main(String[] args) throws Exception{
    Flux<String> delayElements = Flux
            .<String>generate(sink -> sink.next("Hello @" + Instant.now().toString()))
            //.take(4)
            .delayElements(Duration.ofSeconds(1));
    
    delayElements.subscribe(
    	    value -> {
    		      System.out.println(value);
    		    }, error -> {
    		      System.out.println(error);
    		    }, () -> {
    		      System.out.println("===== Completed =====");
    		    });

    Thread.sleep(100000);
	}
}