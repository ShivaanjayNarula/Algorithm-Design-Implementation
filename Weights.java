/*
You are given 2 weights and a array of adding weights
Now you can add the weights to 2 to balance the 2 weights such that you use each adding weight exactly once
 */

import java.util.*;
public class Weights {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int weight1 = sc.nextInt();
        int weight2 = sc.nextInt();
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        if(balance(weight1, weight2, nums))
        {
            System.out.print("True");
        }
        else
        {
            System.out.print("False");
        }
    }

    public static boolean balance(int weight1, int weight2, int[] nums) {
        int n = nums.length;
        boolean[] used = new boolean[n];
        return isPossible(weight1, weight2, nums, used, 0);
    }

    public static boolean isPossible(int weight1, int weight2, int[] nums, boolean[] used, int id) {
        if(weight1 == weight2)
        {
            return true;
        }
        int n = nums.length;
        if(id >= n)
        {
            return false;
        }
        boolean check = false;
        if(!used[id])
        {
            used[id] = true;
            check = isPossible(weight1 + nums[id], weight2, nums, used, id + 1);
            if(!check)
            {
                check = isPossible(weight1, weight2 + nums[id], nums, used, id + 1);
            }
            used[id] = false;
        }
        if(!check)
        {
            check = isPossible(weight1, weight2, nums, used, id + 1);
        }
        return check;
    }
}