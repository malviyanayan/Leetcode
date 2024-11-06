import java.util.TreeMap;

class Leetcode143{
    public static void main(String[] args){

    }

    static void reorderList(ListNode head) {
        TreeMap<Integer,ListNode> map = new TreeMap<>();
        int size = 1;

        ListNode temp = head;
        while(temp != null){
            size ++;
            temp =temp.next;
        }

        int i=1;
        int count = 1;

        while(i<=size){
            map.put(count++,head);
            if(i != size){
                temp = goNode(size, head);
                map.put(count++, temp);
            }
            i++;
            size--;
            head = head.next;
        }

        for(Integer cnt : map.keySet()){
            if(cnt == 1){
                head= temp = map.get(cnt);
                head.next = null;
            }
            temp.next = map.get(cnt);
            temp = temp.next;
            temp.next = null;
        }

    }

    static ListNode goNode(int pos,ListNode head){
        int count = 1;
        while(head != null && count != pos){
            count ++;
            head = head.next;
        }
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