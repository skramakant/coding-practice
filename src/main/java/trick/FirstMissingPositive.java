package trick;

public class FirstMissingPositive {


    // using cyclic sort
    public int firstMissingPositive(int[] nums) {
        int maxNum = nums.length;

        // 1, 2, 0
        //[3,4,-1,1]
        // [7,8,9,11,12]
        // [1]
        int i = 0;
        while (i < maxNum) {
            int correctIndex = nums[i] - 1; // 1 at 0th index
            if (nums[i] > 0 && nums[i] <= maxNum && nums[i] != nums[correctIndex]) {
                int t = nums[correctIndex];
                nums[correctIndex] = nums[i];
                nums[i] = t;
            } else {
                i++;
            }
        }

        for(int j=0;j<maxNum; j++) {
            if((j+1) != nums[j]) {
                return j+1;
            }
        }

        return maxNum+1;
    }
    public int firstMissingPositive1(int[] nums) {
        int maxIndex = nums.length;

        // 1, 2, 0
        //[3,4,-1,1]
        // [7,8,9,11,12]
        // [1]
        for (int i = 0; i<maxIndex; i++) {
            if(nums[i] <= 0 || nums[i] > maxIndex) {
                nums[i] = Integer.MAX_VALUE;
            }
        }

        // 1, 2, MAX
        //[3,4,MAX,1]
        //[MAX,MAX,MAX,MAX,MAX]
        for (int i=0; i<maxIndex; i++) {
            if (nums[i] == Integer.MAX_VALUE) {
                continue;
            }

            int x = Math.abs(nums[i]);

            if(x < Integer.MAX_VALUE && nums[x-1] > 0 ) {
                nums[x-1] = -1 * nums[x-1];
            }
        }

        // - 1 , -2, MAX
        // [-3, 4, -MAX, -1]
        for(int i = 0; i<maxIndex; i++) {
            if(nums[i] > 0) {
                return i + 1;
            }
        }

        return maxIndex;
    }
}
