package DSA.dp.knapsack01;

public class CountSubsetWithGivenDiff {

    //    https://leetcode.com/problems/target-sum/description/
    public static void main(String[] args) {

        int arr[] = {5, 2, 6, 4}, diff = 3;
        System.out.println(countPartitions(arr, diff));

    }

    public static int countPartitions(int[] arr, int diff) {
        int total = 0;
        for (int num : arr) {
            total += num;
        }
        if ((total - diff) < 0 || (total - diff) % 2 != 0) return 0;
        int target = (total - diff) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int num : arr) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] + dp[j - num];
            }
        }
        return dp[target];
    }

    //s1-s2 = x
    //s1+s2 = total
    //2s1= total+x
    //s1= (total+x)/2
}
