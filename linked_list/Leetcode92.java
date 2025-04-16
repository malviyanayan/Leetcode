class Leetcode92 {

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



    // with using arrays
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode[] list = new ListNode[right];
        int i=1;
        ListNode temp = head;

        int x = left;
        if(left == 1)head = null;

        while(temp != null && i != right){
            list[i-1] = temp;
            temp = temp.next;
        }

        while(left < right){
            ListNode ttemp = list[left];
            list[left] = list[right];
            list[right] = ttemp;
            left++;
            right--;
        }

        list[list.length -1].next = temp;
        if(head == null){
            head = list[0];
            list[list.length -1] = temp;
        }else {
            temp = head;
            for(int j=0;j<x;j++){
                head = head.next;
            }
        }

        return head;

    }

    public ListNode reverseBetween1(ListNode head, int left, int right) {
        if(left == right || head == null || head.next == null)return head;

        ListNode prev = null, current = head, next = head.next,head1 = null, newnode = null;
        int i = 1;

        while(i != left){
            prev = current;
            current = current.next;
            i++;
        }

        next = current.next;
        newnode = head1 = current;
        newnode.next = null;

        while(i != right){
            current = next;
            next = next.next;

            current.next = head1;
            head1 = current;
            i++;
        }

        newnode.next = next;

        if(prev == null)head = head1;
        else prev.next = head1;

        return head;
    }

    public static void main(String[] args) {

    }
}