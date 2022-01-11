package com.eg;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class FluxSchedulerEg {
	public static void main(String[] args) throws Exception{
		Flux.just(1, 2, 3, 4)
		  .log()
		  .map(i -> i * 2)
		  .subscribeOn(Schedulers.parallel())
		  .subscribe(System.out::println);
		
		Thread.sleep(100000);
	}
}
