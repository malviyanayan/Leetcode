class Leetcode61 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("[" + head + "]");
        System.out.println(rotateRight(head, 0));
    }

    static int rotateRight(ListNode head, int k) {
        
        return 1;
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
