package old;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode start = head, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        slow =  reverse(slow);
        while (slow != null) {
            if (start.val != slow.val) {
                return false;
            }
            start = start.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head!= null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode end = headA;
        while (end != null) {
            end = end.next;
        }
        end.next = headA;
        ListNode fast = headA, slow = headB;
        while (fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

}
