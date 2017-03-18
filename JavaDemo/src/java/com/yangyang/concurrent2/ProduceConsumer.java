package com.yangyang.concurrent2;


class Depot{
    private int size; //actual size
    private int capacity; //depot capacity

    public Depot(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    public synchronized void produce(int val){
        try {
            int left = val;
            while (left > 0){

                while (size >= capacity) wait();

                int inc = (size + left) > capacity ? (capacity-size) : left;

                size += inc;
                left -= inc;

                System.out.printf("%s produce(%3d) --> left=%3d, inc=%3d, size=%3d\n",
                        Thread.currentThread().getName(), val, left, inc, size);

                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void consumer(int val){
        try {
            int left = val;
            while (left > 0){
                while ( size < left) wait();

                int desc = size < left ? size : left;

                left -= desc;
                size -= desc;
                System.out.printf("%s consume(%3d) <-- left=%3d, dec=%3d, size=%3d\n",
                        Thread.currentThread().getName(), val, left, desc, size);
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Producer{
    private Depot depot;

    public Producer(Depot depot) {
        this.depot = depot;
    }
    public void produce(int val){
        new Thread(()->depot.produce(val)).start();
    }
}
class Consumer{
    private Depot depot;

    public Consumer(Depot depot) {
        this.depot = depot;
    }
    public void consumer(int val){
        new Thread(()->depot.consumer(val)).start();
    }
}

public class ProduceConsumer {
    public static void main(String[] args) {
        Depot depot = new Depot(100);
        Producer producer = new Producer(depot);
        Consumer consumer = new Consumer(depot);

        producer.produce(120);
        producer.produce(60);

        consumer.consumer(90);
        consumer.consumer(150);
        producer.produce(110);
        consumer.consumer(200);


    }
}
