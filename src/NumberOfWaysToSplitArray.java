public class NumberOfWaysToSplitArray {
    //        2270. Number of Ways to Split Array
//        https://leetcode.com/problems/number-of-ways-to-split-array/description/
//        meta
    public static void main(String[] args) {
        int[] nums = {10,4,-8,7};

        System.out.println(waysToSplitArray2(nums));


    }

//    this solution is optimise and this solution is accepted.
    public static int waysToSplitArray2(int[] nums){
        int n = nums.length;
        long totalSum = 0;

        for(int num: nums){
            totalSum += num;
        }

        int possibleSplits = 0;
        long leftSum = 0;
        for(int i = 0; i < n-1; i++){
            leftSum += nums[i];
            long rightSum = totalSum - leftSum;

            if(leftSum >=  rightSum){
                possibleSplits++;
            }
        }

        return possibleSplits;

    }


//    this is brute force solution but its not passes all the test cases
    public static int waysToSplitArray(int[] nums){
        int n = nums.length;
        int possibleSplits = 0;

//        initialise prefix sum array
        long[] prefixSum = new long[n];

//        set first value at prefix sum
        prefixSum[0] = nums[0];

//        iterate nums and add to prefix sum
        for(int i = 1; i < n; i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

//        now check if first part is >= second part
        for(int i = 0; i < n; i++){
//            here i have comparing to first part with [n-1], which is total sum of array or second part
            if(prefixSum[i] >= prefixSum[n-1]){
                possibleSplits += 1;
            }
        }

        return possibleSplits;

    }
}
