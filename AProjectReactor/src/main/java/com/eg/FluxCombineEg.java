package com.eg;

import reactor.core.publisher.Flux;

public class FluxCombineEg {
	public static void main(String[] args) {
		Flux.just(1, 2, 3, 4)
		  .log()
		  .map(i -> i * 2)
		  .zipWith(Flux.range(0, Integer.MAX_VALUE), 
		    (one, two) -> one+"->"+two)
		  .subscribe(System.out::println);
	}
}
