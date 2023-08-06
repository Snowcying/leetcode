package code.M8;

public class S155 {
    static class MinStack {

        public int min = Integer.MAX_VALUE;
        private int[] nums = new int[30001];
        private int top = 0;

        public MinStack() {

        }

        public void push(int val) {
            nums[top] = val;
            top++;
            min = Math.min(val, min);
        }

        public void pop() {
            if (top > 0) {
                int val = nums[top - 1];
                if (val > min) {
                    top--;
                } else {
                    min = Integer.MAX_VALUE;
                    top--;
                    for (int i = 0; i < top; i++) {
                        min = Math.min(min, nums[i]);
                    }
                }
            }
        }

        public int top() {
            return nums[top - 1];
        }

        public int getMin() {
            return min;
        }
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());


    }
}
