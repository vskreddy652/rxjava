package com.eg;

import reactor.core.publisher.Flux;

public class FluxMapMethodReference {
	public static void main(String[] args) {
		Flux.just(10)
	    .map(FluxMapMethodReference::somemethod)
	    //can invoke map() operator multiple times
	    .subscribe(System.out::println);
	   
	}
	
	public static int somemethod(int val){
		return val + 5;
	}
}
