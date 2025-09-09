package com.geetha.DSA;
import java.util.Scanner;
import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of coin denominations
        System.out.println("Enter Number of coins");
        int m = sc.nextInt();
        int[] coins = new int[m];

        // Read the coin denominations
        System.out.println("Enter "+m+" coins");
        for (int i = 0; i < m; i++) {
            coins[i] = sc.nextInt();
        }

        // Read the target amount
        System.out.println("Enter target to find");
        int target = sc.nextInt();

        // Calculate the minimum number of coins
        int minCoins = minCoinsForChange(coins, target);

        // Print the result
        System.out.println("The minimum coins are" + minCoins);

        sc.close();
    }

    // Function to calculate minimum number of coins
    public static int minCoinsForChange(int[] coins, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, target + 1); // large value
        dp[0] = 0;

        for (int i = 1; i <= target; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[target] > target ? -1 : dp[target];
    }
}
