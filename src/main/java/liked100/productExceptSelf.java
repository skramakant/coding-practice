package liked100;

public class productExceptSelf {
    public int[] productExceptSelf(int[] nums){
        int[] ans = new int[nums.length];

//       product at that position = prefix at that postion * post fix at that postion
        // [1,2,3]   1 is prifix of 2 and 3 is post fix of 2

        int prefix = 1;

        // prefix for that postion
        for(int i=0;i<nums.length; i++) {
            ans[i] = ans[i] + prefix;
            prefix = prefix * nums[i];
        }


        int postfix = 1;
        for(int j = nums.length-1; j>=0; j--) {
            // prefix at location * postfix at that location
            ans[j] = ans[j] * postfix;
            postfix = postfix * nums[j];
        }

        return ans;
    }
}
