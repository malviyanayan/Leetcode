class Leetcode61 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("[" + head + "]");
        System.out.println(rotateRight(head, 2));
    }

    static ListNode rotateRight(ListNode head, int k) {
        int length = 0;

        ListNode temp = head;
        while(temp != null){
            length++;
            temp = temp.next;
        }

        if(length<2 || k == 0 || k==length)return head;

        k = k%length;
        ListNode prev = null;
        temp = head;
        int i = 1;
        while(i <= length-k && temp != null){
            i++;
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        prev = temp;
        while(prev.next != null)prev = prev.next;
        prev.next = head;
        
        return temp;
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
