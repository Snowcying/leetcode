package project;

public class concurrentTest {
    static void sisuo() throws InterruptedException {
        Object obj1=new Object();
        Object obj2=new Object();

        Thread t1=new Thread(()->{
            synchronized (obj1){
                System.out.println("t1 get obj1");
                try{
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2){
                    System.out.println("t1 get obj2");
                }
            }
        });

        Thread t2=new Thread(()->{
            synchronized (obj2){
                System.out.println("t2 get obj2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj1){
                    System.out.println("t2 get obj1");
                }
            }
        });
        t1.start();
        t2.start();

        obj1.wait();
    }
    public static void main(String[] args) throws InterruptedException {
//    sisuo();
        Object obj1=new Object();
        Object obj2=new Object();
        myThread1 t1 = new myThread1(obj1, obj2);
        myThread2 t2 = new myThread2(obj1, obj2);
        Thread th1=new Thread(t1);
        Thread th2=new Thread(t2);
        th1.start();
        th2.start();

    }
}
class myThread1 implements Runnable{
    final Object obj1;
    final Object obj2;

    public myThread1(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {
            synchronized (obj1){
                System.out.println(" get obj1");
                try{
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2){
                    System.out.println(" get obj2");
                }
            }
    }
}

class myThread2 implements Runnable{
    final Object obj1;
    final Object obj2;

    public myThread2(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {
        synchronized (obj2){
            System.out.println(" get obj2");
            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj1){
                System.out.println(" get obj1");
            }
        }
    }
}

class Thread01 extends Thread{
    private int cout=20;
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(500);
                synchronized (this){
                    if(cout<=0){
                        break;
                    }
                    cout--;
                    if(cout>0){
                        System.out.println(Thread.currentThread().getName()+"取出一万元，还剩"+cout+"万元");
                    }else{
                        System.out.println(Thread.currentThread().getName()+"取出一万元，余额已取完！！！");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        Thread01 thread=new Thread01();
//        thread.start();
//        Thread01.
        Thread th1=new Thread(thread,"张三");
        Thread th2=new Thread(thread,"李四");
        Thread th3=new Thread(thread,"王五");
        th1.start();
        th2.start();
        th3.start();
    }
}

class Thread02 extends Thread{
    String name;
    public Thread02(String name) {
        this.name=name;
    }

    @Override
    public void run() {
//        synchronized (this){
            for(int i=0;i<200;i++){
                synchronized (this){
                    System.out.println(this.name+"到了"+i);
                }
//                System.out.println("end");
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
//        }

    }
}
class Test2{
    public static void main(String[] args) {
        Thread02 t1=new Thread02("t1");
        Thread02 t2=new Thread02("t2");
        t1.start();
        t2.start();
//        new Thread02("t3").start();
//        new Thread02("t4").start();
//        new Thread02("t5").start();
    }
}