package ru.nazariene.sorting;

public class Solution {


    /*public static void main(String[] args) {
        int[] test1 = {1,1};
        int[] test2 = {1,2};
        int[] test3 = {1,2,3,4,5,5,6,6,7};
        int[] test4 = {};

        int[] out = test2;

        Solution s = new Solution();
        System.out.println("Num: " + s.removeDuplicates(out));


        for (int i = 0; i<out.length; i++) {
            System.out.println(out[i]);
        }
    }*/

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        int numdups = 0;

        while(i<nums.length) {
            if (i+1 < nums.length && nums[i] > nums[i+1]) {
                break;
            }

            while(i+1 < nums.length && nums[i] == nums[i+1]) {
                numdups++;
                i++;
            }

            if (numdups > 0) {
                exch(nums, i, i-numdups);
            }

            i++;
        }

        return i-numdups;
    }

    protected void exch(int[] inputArray, int a, int b) {
        int curMinValue = inputArray[b];
        inputArray[b] = inputArray[a];
        inputArray[a] = curMinValue;
    }
}