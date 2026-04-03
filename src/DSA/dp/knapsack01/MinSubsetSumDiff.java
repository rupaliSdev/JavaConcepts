package DSA.dp.knapsack01;

public class MinSubsetSumDiff {


    public static void main(String[] args) {
        int[] nums = {3, 9, 7, 3};

        int x = minSubsetSumDiffOpt(nums);
        System.out.println(x);
        int y =minSubsetSumRec(nums);
        System.out.print(y);
    }

    public static int minSubsetSumRec(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        return findMinDifference(nums, total,0,nums.length);
    }

    private static int findMinDifference(int[] nums, int total,int sumCal, int index) {
        if(index==0){
            return Math.abs(total-2*sumCal);
        }
        int include =findMinDifference(nums, total,sumCal+nums[index-1],index-1);
        int exclude =findMinDifference(nums, total,sumCal,index-1);
        return Math.min(include,exclude);
    }

    public static int minSubsetSumDiffOpt(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        int target = total / 2;

        int n = nums.length;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            for (int sum = target; sum >= nums[i]; sum--) {
                //here i index is i-1 index of nums[i];
                dp[sum] = dp[sum - nums[i]] | dp[sum];

            }
        }
        for (int s = target; s >= 0; s--) {
            //nearest to target
            if (dp[s]) {
                return total - 2 * s;
            }
        }

        return 0;
    }
}
