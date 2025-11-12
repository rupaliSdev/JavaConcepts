package DSA.greedy;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {

    }


   /* You are given an array prices where prices[i] is the price of a given stock on the ith day.

    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.*/


    public int maxProfitI(int[] prices) {
        int n = prices.length;

        int min = prices[0];
        int max_profit = 0;

        for(int i =1;i<prices.length;i++){

            max_profit = Math.max(max_profit,prices[i]-min);

            if(prices[i]<min){
                min = prices[i];
            }

        }
        return max_profit;

    }

    public int maxProfitII1st(int[] p) {


        int max_profit =0;
        int valley = p[0],peak = p[0];

        for(int i =0;i< p.length-1;i++){

            while(i<p.length-1 && p[i] >= p[i+1]){
                i++;
            }
            valley = p[i];

            while(i< p.length-1 && p[i] <= p[i+1]){
                i++;
            }
            peak = p[i];

            max_profit+=peak-valley;
        }
        return max_profit;

    }
    public int maxProfitII2nd(int[] p) {




            int max_profit =0;

            for(int i =1;i< p.length;i++){

                if(p[i]>p[i-1]){

                    max_profit += (p[i]-p[i-1]);
                }



            }
            return max_profit;

        
    }


}
