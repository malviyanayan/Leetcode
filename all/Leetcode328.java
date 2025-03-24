class Leetcode328 {
    public static void main(String[] args) {
        
    }   
    
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)return head;
        ListNode prev = head,temp = head.next;
        ListNode evenList = null,evenTemp=null;

        while(prev != null && temp != null){
            prev.next = temp.next;
            if(evenList == null){
                evenList = evenTemp = temp;
                evenList.next = null;
            }
            else {
                evenTemp.next = temp;
                evenTemp = temp;
                evenTemp.next = null;
            }
            
            if(prev.next == null){
                prev.next = evenList;
                break;
            }
            prev = prev.next;
            if(prev.next == null){
                prev.next = evenList;
                break;
            }
            temp = prev.next;
        }
        prev.next = evenList;


        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
