import java.util.ArrayList;

class Leetcode725 {
    public static void main(String[] args) {
        
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        // System.out.println(head);

        // ListNode head = null;

        // ListNode head = new ListNode(1);
        // ListNode[] ans = splitListToParts(head, 5);
        ListNode[] ans = splitListToParts(head, 2);
        for(ListNode node : ans){
            System.out.println(node);
        }
    }

    static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        if(head == null)return ans;
        int length = 0;
        ListNode temp = head;
        while (temp!=null) {
            temp = temp.next;
            length++;
        }

        int devide = length/k,mod = length % k;

        int i = 0;
        
        temp = null;
        do{
            ans[i] = head;
            int round = 0;
            if(mod != 0){
                round = devide + 1;
                mod--;
            }else round = devide;
            
            int s = 0;
            while(s<round){
                temp = head;
                head = head.next;
                s++;
            }

            temp.next = null;

            i++;
        }while(head != null);



        return ans; 
    }
    
}



class Listcode {
    int val;
    ListNode next;

    Listcode() {
    }

    Listcode(int val) {
        this.val = val;
    }

    Listcode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val + ", " + next;
    }
}

