import java.util.TreeMap;

class Leetcode143{
    public static void main(String[] args){

    }

    static void reorderList(Listcode head) {
        TreeMap<Integer,Listcode> map = new TreeMap<>();
        int size = 1;

        Listcode temp = head;
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

    static Listcode goNode(int pos,Listcode head){
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
    Listcode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, Listcode next) { this.val = val; this.next = next; }
}