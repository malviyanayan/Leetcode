import java.util.TreeMap;
import java.util.Map.Entry;

class Leetcode82{

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null, curr = head;
        boolean flag = false;

        while (curr != null) {
            ListNode prev1 = curr;
            ListNode curr1 = curr.next;
            flag = false;

            while (curr1 != null) {
                if (curr1.val == curr.val) {
                    flag = true;
                    prev1.next = curr1.next;
                } else {
                    prev1 = curr1;
                }
                curr1 = curr1.next;
            }

            if (flag) {
                if (curr == head) {
                    head = curr.next;
                    curr = head;
                } else {
                    prev.next = curr.next;
                    curr = curr.next;
                }
            } else {
                if (curr == head) {
                    prev = curr;
                    curr = curr.next;
                } else {
                    prev.next = curr;
                    prev = curr;
                    curr = curr.next;
                }
            }
        }

        return head;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) return head;

        TreeMap<Integer, ListNode> map = new TreeMap<>();

        while(head != null){

            if(map.containsKey(head.val)){
                map.put(head.val, null);
            }else{
                map.put(head.val, head);
            }

            head = head.next;
        }

        System.out.println(map);

        ListNode temp = null;
        for(java.util.Map.Entry<Integer, ListNode> entry : map.entrySet()){
            if(head == null && entry.getValue() != null){
                head = temp = entry.getValue();
            }else{
                if(entry.getValue() != null){
                    temp.next = entry.getValue();
                    temp = temp.next;
                }
            }
        }

        if(head == null)return null;

        temp.next = null;

        return head;
    }
    
    
    public static void main(String[] args){

    }
}