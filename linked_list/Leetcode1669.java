class Leetcode1669 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int i = 0;
        ListNode temp = list1;
        while(i < a){
            temp = temp.next;
            i++;
        }

        ListNode prev = temp;

        while(i <= b){
            temp = temp.next;
            i++;
        }

        prev.next = list2;

        if(temp == null)return list1;
        else{
            while (list2.next != null) {
                list2 = list2.next;
            }

            list2.next = temp;
        }

        return list1;
    }    

}
