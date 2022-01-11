package com.eg;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Buffering {
   public static void main(String[] args) throws InterruptedException {
      Observable<Integer> observable = Observable.just(1, 2, 3, 4,
         5, 6, 7, 8, 9);

      observable.subscribeOn(Schedulers.io())
         .delay(2, TimeUnit.SECONDS, Schedulers.io())
         .buffer(3)
         .subscribe(new Observer<List<Integer>>() {
            @Override
            public void onSubscribe(Disposable d) {
               System.out.println("Subscribed");
            }
            @Override
            public void onNext(List<Integer> integers) {
               System.out.println("onNext: ");
               for (Integer value : integers) {
                  System.out.println(value);
               }
            }
            @Override
            public void onError(Throwable e) {
               System.out.println("Error");
            }

            @Override
            public void onComplete() {
               System.out.println("Done! ");
            }
         });
      Thread.sleep(3000);
   }
}