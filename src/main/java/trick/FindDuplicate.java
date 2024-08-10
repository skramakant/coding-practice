package trick;

// https://leetcode.com/problems/find-the-duplicate-number/?envType=daily-question&envId=2024-03-24
// 1, 3, 4 , 2 ,2
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        for(int x : nums) {
            int val = Math.abs(x) - 1;
            if (nums[val] > 0 ) {
                nums[val] = -nums[val];
            } else {
              return Math.abs(x);
            }
        }

        return 0;
    }



    // it can be solved using fast and slow pointer similer to linked list
    // https://leetcode.com/problems/find-the-duplicate-number/discuss/72846/My-easy-understood-solution-with-O(n)-time-and-O(1)-space-without-modifying-the-array.-With-clear-explanation.
}
