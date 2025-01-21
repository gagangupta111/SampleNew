package org.example;

// elipsases

// ? extends Number
// type eraser : generics
// try with resources
// how client application recieve the

import scala.collection.immutable.Stream;

import java.util.ArrayList;
import java.util.List;

class Producer implements Runnable{

    private SharedResource sharedResource;

    public Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {

        synchronized (sharedResource){
            try {
                while (sharedResource.list.size() > 9){
                    System.out.println("");
                    sharedResource.wait();
                    Thread.sleep(1000);
                }
                sharedResource.list.add(1);
                sharedResource.notifyAll();
            }catch (Exception exception){

            }

        }

    }
}

class Consumer implements Runnable{

    private Integer id;
    private SharedResource sharedResource;

    public Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {

        synchronized (sharedResource){
            try {
                while (sharedResource.list.isEmpty()){
                    System.out.println("");
                    sharedResource.wait();
                    Thread.sleep(1000);
                }
                System.out.println(sharedResource.list.get(0));
                sharedResource.notifyAll();
            }catch (Exception exception){

            }

        }

    }
}

class SharedResource{

    public List<Integer> list = new ArrayList<>();

}

public class MainExample {


    public static void main(String... args){

        SharedResource sharedResource = new SharedResource();
        Producer producer = new Producer(sharedResource);

        Consumer consumer = new Consumer(sharedResource);

        Thread thread1 = new Thread(producer);
        thread1.start();

        Thread thread2 = new Thread(consumer);
        thread2.start();

    }

}
