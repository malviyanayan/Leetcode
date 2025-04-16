class Leetcode2181 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeNodes(ListNode head) {
        ListNode temp = head.next, prev = head;

        while (temp != null) {
            prev.next = null;
            while (temp != null && temp.val != 0) {
                prev.val += temp.val;
                temp = temp.next;
            }

            if (temp != null && temp.val == 0) {
                prev.next = temp;
                prev = temp;
                temp = temp.next;
            }
        }

        temp = head;

        while (temp.next != null && temp.next.val != 0)
            temp = temp.next;
        temp.next = null;

        return head;
    }

    public ListNode mergeNodes1(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        ListNode temp = head.next;

        int sum = 0;
        while (temp != null) {
            if (temp.val == 0) {
                current.next = new ListNode(sum);
                current = current.next;
                sum = 0;
            } else {
                sum += temp.val;
            }
            temp = temp.next;
        }

        return dummy.next;
    }

}
