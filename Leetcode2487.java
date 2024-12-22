class Leetcode2487{
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(8);

        System.out.println(removeNodes(head));
    }


    
    static ListNode removeNodes(ListNode head) {
        // Step 1: Reverse the linked list
        head = reverseList(head);

        // Step 2: Filter nodes based on the max value seen so far
        int maxVal = Integer.MIN_VALUE;
        ListNode dummy = new ListNode(0); // Dummy node to simplify operations
        ListNode tail = dummy;

        while (head != null) {
            if (head.val >= maxVal) {
                maxVal = head.val;
                tail.next = head; // Add the current node to the result list
                tail = tail.next;
            }
            head = head.next;
        }
        tail.next = null; // Ensure the list ends properly

        // Step 3: Reverse the filtered list to restore the original order
        return reverseList(dummy.next);
    }

    
    static ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }




    

    private static ListNode helper(ListNode head,ListNode temp){
        if(temp == null){
            return head;
        }

        // remove temp prev node...
        head = removePrev(head,temp);

        return helper(head, temp);
    }


    private static ListNode removePrev(ListNode head,ListNode temp){

        while(head != temp && head.val < temp.val){
            head = head.next;
        }

        if(head != temp){
            ListNode current = head.next,prev = head,next = current.next;
            while(current != temp){
                if(current.val < temp.val){
                    prev.next = next;
                }else{
                    prev = current;
                }

                current = next;
                next = next.next;
            }
        }

        return head;
    }
}