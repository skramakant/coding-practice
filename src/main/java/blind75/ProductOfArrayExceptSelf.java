package blind75;

//5 star
// https://leetcode.com/problems/product-of-array-except-self/
public class ProductOfArrayExceptSelf {
    // without extra space
    public int[] productExceptSelf(int[] nums) {

        if(nums.length == 1 || nums.length == 0) {
            return nums;
        }

        int[] ans = new int[nums.length];

        // keep prefix and use result array
        int prefix = 1;
        for(int i =0; i<nums.length; i++) {
            ans[i] = prefix;
            prefix = nums[i] * ans[i];
        }

        // postfix
        int postfix = 1;
        for(int j=nums.length-1; j>=0; j--) {
            ans[j] = ans[j] * postfix;
            postfix = nums[j] * postfix;
        }

        return ans;
    }

    // extra space
    public int[] productExceptSelfExtraSpace(int[] nums) {

        if(nums.length == 1 || nums.length == 0) {
            return nums;
        }

        int[] ans = new int[nums.length];

        // left array product
        int[] left = new int[nums.length];
        left[0] = nums[0];

        for(int i =1; i<nums.length; i++) {
            left[i] = left[i-1] * nums[i];
        }

        // right array product
        int[] right = new int[nums.length];
        right[nums.length - 1] = nums[nums.length-1];
        for(int j = nums.length - 2; j>=0; j-- ) {
            right[j] = right[j+1] * nums[j];
        }

        for(int i=0; i<nums.length; i++) {
            if (i== 0) {
                ans[i] = right[i+1];
            }else if(i == nums.length -1) {
                ans[i] = left[i-1];
            }else {
                ans[i] = left[i-1] * right[i+1];
            }

        }

        return ans;

    }
}
