package code;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class ThreadLocalExample implements Runnable {

    // SimpleDateFormat 不是线程安全的，所以每个线程都要有自己独立的副本
    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample obj = new ThreadLocalExample();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(obj, "" + i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
    }

    @Override
    public void run() {
        System.out.println("Thread Name= " + Thread.currentThread().getName() + " default Formatter = " + formatter.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //formatter pattern is changed here by thread, but it won't reflect to other threads
        formatter.set(new SimpleDateFormat());

        System.out.println("Thread Name= " + Thread.currentThread().getName() + " formatter = " + formatter.get().toPattern());
    }

}


class Person {
    int num;

    public Person() {
    }

    public Person(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

public class Test {
    private static final int MAXIMUM_CAPACITY = 99999;

    public static void incr(Person person) {
        person.num++;
    }

    static void add(int[] nums) {
        nums[1] = 11;
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public static void main(String[] args) {
//        int i=400;
//        Integer i1=i;
//        Integer i2=new Integer(i);
//        System.out.println(i1==i2);
//        int[] nums=new int[2];
//        for(int x:nums){
//            System.out.println(x);
//        }
//        add(nums);
//        for(int x:nums){
//            System.out.println(x);
//        }
//        System.out.println(nums);
        System.out.println(tableSizeFor(9));
    }
}

class DeadLockCannotInterruptDemo {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName() + " get lock1");
                    try {
                        Thread.sleep(10);
                        synchronized (lock2) {
                            System.out.println(Thread.currentThread().getName() + " get lock2");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + " get lock2");
                    try {
                        Thread.sleep(10);
                        synchronized (lock1) {
                            System.out.println(Thread.currentThread().getName() + " get lock1");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        threadA.start();
        threadB.start();

        TimeUnit.SECONDS.sleep(3);
        System.out.println("main thread begin to interrupt " + threadA.getName() + " and " + threadA.getName() + " will release lock1...");
        threadA.interrupt();
    }
}

class Test1 extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("create");
    }

    public static void main(String[] args) {
        Test1 test = new Test1();
        Thread t1 = new Thread(test);
        t1.start();
        System.out.println(Thread.currentThread().getName());
    }
}

class Test2 implements Runnable {
    @Override
    public void run() {
        System.out.println("create");
    }

    public static void main(String[] args) {
        Test1 test = new Test1();
        Thread t1 = new Thread(test);
        t1.start();
        System.out.println(Thread.currentThread().getName());
    }
}

class Test3 implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("Thread is Created");
        return "OK";
    }

    public static void main(String[] args) throws Exception {
        Test3 test = new Test3();
        FutureTask futureTask = new FutureTask(test);
        Thread thread = new Thread(futureTask);
        thread.start();
        String str = (String) futureTask.get(5, TimeUnit.SECONDS);
        System.out.println(str);
        System.out.println(Thread.currentThread().getName());
    }
}


// 注意类名必须为 Main, 不要有任何 package xxx 信息
class Main {
    static int[][][] vis = new int[310][310][310];
    static int[] nums = new int[310];

    public static int dfs(int left, int right, int root) {
        if (left > right) {
            return 0;
        }
        if (vis[left][right][root] != 0) {
            return vis[left][right][root];
        }
        int res = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            int l = dfs(left, i - 1, i);
            int r = dfs(i + 1, right, i);
            res = Math.min(res, l + r + nums[i] * nums[root]);
        }
        vis[left][right][root] = res;
        return res;


    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();

            for (int i = 1; i <= n; i++) {
                nums[i] = in.nextInt();
            }
            nums[0] = 0;
//            Arrays.fill(vis,-1);
//            Arrays
            int ans = dfs(1, n, 0);
            System.out.println(ans);
        }
    }
}

class finalV {
    public static void main(String[] args) {
        final StringBuffer a = new StringBuffer("abcdefg");
//执行如下语句将报告编译期错误：
//        a=new StringBuffer("");
//但是，执行如下语句则可以通过编译：
        a.append(" broken!");
        System.out.println(a);
    }
}

