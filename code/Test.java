package code;
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
    public  static void incr(Person person){
        person.num++;
    }
    static void add(int[] nums){
        nums[1]=11;
    }
    public static void main(String[] args) {
//        int i=400;
//        Integer i1=i;
//        Integer i2=new Integer(i);
//        System.out.println(i1==i2);
        int[] nums=new int[2];
        for(int x:nums){
            System.out.println(x);
        }
        add(nums);
        for(int x:nums){
            System.out.println(x);
        }
//        System.out.println(nums);
    }
}
