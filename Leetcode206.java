class Leetcode206{
    public static void main(String[] args){

    }

    public ListNode reverseList(ListNode head) {
        ListNode temp = null;
        return helper(head, temp);
    }


// Recursion Easy Question
    private static ListNode helper(ListNode head,ListNode temp){
        if(head == null){
            return temp;
        }

        ListNode ttemp = head;
        head = head.next;
        ttemp.next = null;

        if(temp == null){
            temp = ttemp;
        }else{
            ttemp.next = temp;
            temp = ttemp;
        }

        return helper(head, temp);
    }


}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}