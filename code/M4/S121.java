package code.M4;

public class S121 {
    static public int maxProfit(int[] prices) {
        int minPrice=prices[0];
        int res=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<minPrice){
                minPrice=prices[i];
            }else{
                res=Math.max(prices[i]-minPrice,res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices={2,5,1,3};
//        int[] prices={7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
