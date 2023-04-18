package project;

import java.util.concurrent.Callable;

public class TestFuture {
    public static void main(String[] args) {
        new MyFuture("线程a");
    }

}
class MyFuture implements Callable<Integer>{
    private String name;

    public MyFuture(String name) {
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
//        return null;
        Integer sum = 0;
        for (int i = 0; i < 100; i++) {
            System.out.println(this.name + i);
            sum += i;
        }
        return sum;
    }
}