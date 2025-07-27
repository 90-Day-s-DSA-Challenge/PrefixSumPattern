import java.util.Arrays;

//1991. Find the Middle Index in Array
//https://leetcode.com/problems/find-the-middle-index-in-array/description/
public class FindTheMiddleIndexInArray {
    public static void main(String[] args) {

        int[] nums = {2, 3, -1, 8, 4};
        System.out.println(findMiddleIndex(nums));

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

