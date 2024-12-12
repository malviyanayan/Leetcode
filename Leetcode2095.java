class Leetcode2095 {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        // head.next = new ListNode(2);
        // head.next.next = new ListNode(3);
        // head.next.next.next = new ListNode(4);
        // head.next.next.next.next = new ListNode(5);

        ListNode ans = deleteMiddle(head);
        ListNode temp = ans;
        while(temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    static ListNode deleteMiddle(ListNode head) {
        if(head.next == null)return null;
        int x = 0;
        ListNode temp = head;
        while(temp != null){
            x++;
            temp = temp.next;
        }
        int del = x/2;
        int i = 0;
        temp = head;
        ListNode prev = null;
        while(temp != null && i<del){
            prev = temp;
            temp = temp.next;
            i++;
        }
        prev.next = temp.next;
        return head;
    }
    
}

class ListNode {
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