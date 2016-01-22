package com.foolver.hawtdispatch;

import java.util.concurrent.Semaphore;

public class App implements Async {

    public static void main(String[] args){
        Example ex = new Example();
        ex.run();
    }

    public static class Example implements Async{

        public void run(){

            final Semaphore done = new Semaphore(- 100000);

            for(int i =0;i<100000;i++){
                final int k = i;
                go(() -> {
                    for (int j = 0; j < 10; j++) {
                        System.out.println(Thread.currentThread().getId() + " - test" + k + " )" + j);
                    }
                    done.release();
                });
            }


            try {
                done.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
