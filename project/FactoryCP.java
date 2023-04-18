package project;

public class FactoryCP {
    int[] arr = new int[1];
    int count = 0;

    public synchronized void setProduct(int num) {
        try {
            System.out.println(Thread.currentThread().getName()+"setProduct");
            Thread.sleep(1000);
            arr[0]=num;
            System.out.println("生产了"+arr[0]+"物品");
            count++;
            if(count==1){
                this.notify();
            }
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public synchronized void getProduct(){
        try {
            System.out.println(Thread.currentThread().getName()+"getProduct");
            Thread.sleep(1000);
            System.out.println("消费了"+arr[0]+"物品");
            count--;
            if(count==0){
                this.notify();
            }
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer extends Thread{
    FactoryCP factory;

    public Consumer(FactoryCP factory) {
        this.factory = factory;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            factory.getProduct();
        }
    }
}
class Product extends Thread{
    FactoryCP factory;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            factory.setProduct(i);
        }
    }

    public Product(FactoryCP factory) {
        this.factory = factory;
    }
}

class Test{
    public static void main(String[] args) {
        FactoryCP factory=new FactoryCP();
        Product p=new Product(factory);
        Consumer c= new Consumer(factory);

        p.start();
        c.start();
    }
}
