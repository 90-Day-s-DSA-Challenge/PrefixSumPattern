import java.util.Arrays;

public class RunningSumOf1DArray {
//    1480. Running Sum of 1d Array
//    https://leetcode.com/problems/running-sum-of-1d-array/description/
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        int[] result = sumOfRunningArray(nums);

        System.out.println(Arrays.toString(result));

    }

    public static int[] sumOfRunningArray(int[] nums){
        int m = nums.length;

        for(int i = 1; i < m; i++){
            nums[i] = nums[i] + nums[i - 1];

//            nums[i] = nums[i] + nums[i - 1];
//            (i = 0) = 1
//            (i = 1) = 2 + 1 = 3
//            (i = 2) = 3 + 3 = 6
//            (i = 3) = 4 + 6 = 10
        }

        return nums;
    }
}
