import java.util.Arrays;

//1991. Find the Middle Index in Array
//https://leetcode.com/problems/find-the-middle-index-in-array/description/
public class FindTheMiddleIndexInArray {
    public static void main(String[] args) {

        int[] nums = {2, 3, -1, 8, 4};
        System.out.println(findMiddleIndexOptimise1(nums));

    }

    public static int findMiddleIndexOptimise1(int[] nums) {
        int n = nums.length;

        // initialise total sum
        int totalSum = 0;

        // totalSum
        for(int num: nums){
            totalSum += num;
        }

        // initialise left sum
        int leftSum = 0;
        for (int i = 0; i< n; i++){
            // find right sum
            int rightSum = totalSum - leftSum - nums[i];

            // if right sum and left sum is equal then return index
            if(leftSum == rightSum){
                return i;
            }

            // add left sum
            leftSum += nums[i];
        }
/**
 i = 0

 leftSum = 0
 rightSum = totalSum - leftSum - nums[0] = 16 - 0 - 2 = 14
 → 0 ≠ 14 → continue
 leftSum += nums[0] = 0 + 2 = 2

 i = 1

 leftSum = 2
 rightSum = totalSum - leftSum - nums[0] = 16 - 2 - 3 = 11
 → 2 ≠ 11 → continue
 leftSum += nums[1] = 2 + 3 = 5

 i = 2

 leftSum = 5
 rightSum = totalSum - leftSum - nums[0] = 16 - 5 - (-1) = 12
 → 5 ≠ 12 → continue
 leftSum += nums[2] = 5 + (-1) = 4

 i = 3

 leftSum = 4
 rightSum = totalSum - leftSum - nums[0] = 16 - 4 - 8 = 4
 → 4 = 4 → found
return i = 3



 */
        return -1;

    }

    public static int findMiddleIndex(int[] nums) {
        int n = nums.length;

        int[] leftSum = new int[n];
        int[] rightSum = new int[n];


        // left comulative sum
        leftSum[0] = nums[0];
        for(int i = 1; i < n; i++){
//            leftSum[i-1] => means add current with left one prev
            leftSum[i] = leftSum[i-1] + nums[i];
        }

        // right comulative sum
        rightSum[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--){
//            rightSum[i+1] => means add current with right one next
            rightSum[i] = rightSum[i+1] + nums[i];
        }
        System.out.println(Arrays.toString(leftSum));
        System.out.println(Arrays.toString(rightSum));

        for(int i = 0; i < n; i++){
            if(leftSum[i] == rightSum[i]){
                return i;
            }

        }

        return -1;

    }


}

