import java.util.ArrayList;

class Leetcode25 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        System.out.println(reverseKGroup(head, k));

    }


    static ListNode reverseKGroup(ListNode head, int k) {
        int i = 0;
        ListNode temp = head;
        while(temp != null){
            i++;
            temp= temp.next;
        }

        ListNode[] list = new ListNode[i];
        i=0;
        while(head != null){
            list[i++] = head;
            head = head.next;
        }

        for(i=0;i<list.length;i = i+k){
            if(i+k > list.length)break;
            int s = i;
            int e = i + k - 1;
            while(s<e){
                System.out.println(list[s].val + ", " + list[e].val );
                temp = list[s];
                list[s] = list[e];
                list[e] = temp;
                s++;e--;
            }
        }

        head = null;
        temp = null;

        for(ListNode node : list){
            if(head == null)head = temp = node;
            else{
                temp.next = node;
                temp = node;
            }
        }

        if(temp != null)temp.next = null;

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