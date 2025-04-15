class Leetcode445{

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int extra = 0;

        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode ans = null;

        while(l1 != null && l2 != null){

            if(ans == null){
                ans = new ListNode((l1.val + l2.val + extra) % 10);
            }else{
                ListNode node = new ListNode((l1.val + l2.val + extra) % 10);
                node.next = ans;
                ans = node;
            }

            extra = (l1.val + l2.val + extra)/10;

            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            if(ans == null){
                ans = new ListNode((l1.val + extra) % 10);
            }else{
                ListNode node = new ListNode((l1.val + extra) % 10);
                node.next = ans;
                ans = node;
            }
            extra = (l1.val + extra)/2;
            l1 = l1.next;
        }

        while(l2 != null){
            if(ans == null){
                ans = new ListNode((l2.val + extra) % 10);
            }else{
                ListNode node = new ListNode((l2.val + extra) % 10);
                node.next = ans;
                ans = node;
            }
            extra = (l2.val + extra)/10;
            l2 = l2.next;
        }

        if(extra != 0){
            ListNode node = new ListNode(extra);
                node.next = ans;
                ans = node;
        }


        return ans;
    }


    static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null, curr = head, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args){

    }
}