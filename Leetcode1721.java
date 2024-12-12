public class Leetcode1721 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;


        System.out.println(swapNodes(head, k));
    }


    // Using Array
    static ListNode swapNodes(ListNode head, int k) {
        int length = 0;
        ListNode temp = head;
        while(temp != null){
            length++;
            temp = temp.next;
        }

        int i = 0;
        ListNode[] nodes = new ListNode[length];
        while(head!=null){
            nodes[i++] = head;
            head = head.next;
        }

       

        ListNode temp1 = nodes[k-1];
        nodes[k-1] = nodes[nodes.length-k];
        nodes[nodes.length-k] = temp1;

        head = null;temp = null;
        for(ListNode node :nodes){
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