package slowfast;

import java.util.List;

//https://leetcode.com/problems/reorder-list/?envType=daily-question&envId=2024-03-23
// Input: head = [1,2,3,4]
// Output: [1,4,2,3]
public class ReorderList {
    public void reorderList(ListNode head) {
        // first reverse the second half of the list
        // then one pointer at head, second at mid
        // keep doing the swap or create the new list here if allowed

        ListNode slow = head, fast = head, pre = head;

        while (fast!=null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }

        // list having odd elements
        // then make move slow, so first half will be bigger then second half
        if(fast != null) {
            pre = slow;
             slow = slow.next;
        }


        pre.next = null;  // this is important to break the cycle

        slow = reverse(slow);

        fast = head;

        // 1 ,2 , 4, 3
        // 1, 4, 2, 3


        while (fast != slow && slow != null) {
            ListNode temp = slow.next;
            slow.next = fast.next;
            fast.next = slow;
            fast = slow.next;
            slow = temp;
        }

//        merge(head, slow);
    }

    void merge(PalindromeLinkedList.ListNode l1, PalindromeLinkedList.ListNode l2) {
        while (l1 != null) {
            PalindromeLinkedList.ListNode n1 = l1.next, n2 = l2.next;
            l1.next = l2;

            if (n1 == null)
                break;

            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null, curr = head;

        while (curr!= null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }


    public static class ListNode {
        int val;
        ListNode next;
        public ListNode() {

        }
        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }
}
