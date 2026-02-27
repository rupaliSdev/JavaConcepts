package DSA.backtracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinCombination {


    public static int minCount = Integer.MAX_VALUE;
    public static HashMap<Integer, Integer> bestMap = new HashMap<>();

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        Arrays.sort(coins);
        dfs1(coins, 0, amount, new HashMap<>(), 0);
        for (Map.Entry<Integer, Integer> keyValue : bestMap.entrySet()) {
            System.out.println(keyValue.getKey() + " - " + keyValue.getValue());
        }

    }

    private static void dfs(int[] coins, int index, int amount, HashMap<Integer, Integer> currMap, int currCount) {
        if (amount < 0 || index == coins.length) {
            return;
        }
        if (amount == 0) {
            if (currCount < minCount) {
                minCount = currCount;
                bestMap = new HashMap<>(currMap);
            }
            return;
        }
        if (minCount <= currCount) {
            return;
        }
        if (amount >= coins[index]) {
            currMap.put(coins[index], currMap.getOrDefault(coins[index], 0) + 1);
            dfs(coins, index, amount - coins[index], currMap, currCount + 1);
            currMap.put(coins[index], currMap.get(coins[index]) - 1);
            if (currMap.get(coins[index]) == 0) {
                currMap.remove(coins[index]);
            }
        }
        dfs(coins, index + 1, amount, currMap, currCount);

    }

    private static void dfs1(int[] coins, int start, int amount, HashMap<Integer, Integer> currMap, int currCount) {
        if (amount < 0) {
            return;
        }
        if (amount == 0) {
            if (currCount < minCount) {
                minCount = currCount;
                bestMap = new HashMap<>(currMap);
            }
            return;
        }
        if (minCount <= currCount) {
            return;
        }

        for (int i = start; i < coins.length; i++) {

            if (amount >= coins[i]) {
                currMap.put(coins[i], currMap.getOrDefault(coins[i], 0) + 1);
                dfs1(coins, i, amount - coins[i], currMap, currCount + 1);
                currMap.put(coins[i], currMap.get(coins[i]) - 1);
                if (currMap.get(coins[i]) == 0) {
                    currMap.remove(coins[i]);
                }
            }

        }

    }


}
