package slowfast;

//    // https://leetcode.com/problems/find-the-duplicate-number/discuss/72846/My-easy-understood-solution-with-O(n)-time-and-O(1)-space-without-modifying-the-array.-With-clear-explanation.
public class FindDuplicateSlowFastPointer {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]]; // node pointing to another node similer to liked list

        while (slow != fast) {
            slow = nums[slow]; // one step
            fast = nums[nums[fast]]; // 2 step
        }

        // after this loop it will ensure its having the loop
        // flods algo to find the starting point of this

        fast = 0;

        while (fast != slow) {
            fast = nums[fast]; // move 1 step each to get cycle starting point
            slow = nums[slow];
        }

        return slow;
    }
}
