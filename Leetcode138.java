import java.util.HashMap;

class Leetcode138{
    // private static Node deepCopy(Node head){
    //     Node temp = null,ttemp = null;
    //     Node h = head;

    //     while(h != null){
    //         Node n = new Node(h.val);
    //         if(temp == null){
    //             temp = ttemp = n;
    //         }else{
    //             ttemp.next = n;
    //             ttemp = n;
    //         }
    //         h = h.next;
    //     }

    //     return temp;
    // }

    // static Node copyRandomList(Node head) {
    //     if(head == null)return null;

    //     Node copy = deepCopy(head);
    //     Node h = head,copyh = copy;
        
    //     while(h != null){
    //         if(h.random == null){
    //             copyh.random = null;
    //         }else{
    //             Node random = h.random,rtemp = head;
    //             int i=0;
    //             while(rtemp != null){
    //                 i=1;
    //                 if(rtemp == random){
    //                     break;
    //                 }
    //                 rtemp = rtemp.next;
    //             }

    //             rtemp = copy;
    //             int j = 0;
    //             while(rtemp != null){
    //                 j++;
    //                 if(i==j)break;
    //                 rtemp = rtemp.next;
    //             }
    //             copyh.random = rtemp;
    //         }

    //         h = h.next;
    //         copyh = copyh.next;
    //     }

    //     return copy;
    // }

    public static void main(String[] args){
        Node n = new Node(1);
        n.next = new Node(2);
        n.next.next = new Node(3); 
        n.next.next.next = new Node(4); 
        n.next.next.next.next = new Node(5); 



        Node n1 = copyRandomList(n);

        System.out.println("List is : ");
        while (n1 != null) {
            System.out.print(n.val + ", ");
            if(n1 == n)System.out.println("not copy");
            n = n.next;
            n1 = n1.next;
        }
    }


    static Node deepCopy(Node head){
        Node head2 = new Node(head.val);
        Node t1 = head.next;
        Node t2 = head2;
        while(t1 != null){
            Node temp = new Node(t1.val);
            t2.next = temp;
            t2 = t2.next;
            t1 = t1.next;
        }
        return head2;
    }

    static Node copyRandomList(Node head) {
        if(head == null)return null;
        // Step-1 Create DeepCopy without random connections
        Node head2 = deepCopy(head);
        HashMap<Node,Node> map = new HashMap<>();
        Node h2 = head2;
        while(head != null && h2 != null){
            map.put(head, h2);
            head = head.next;
            h2 = h2.next;
        }

        for(Node key : map.keySet()){
            if(key.random != null){
                map.get(key).random = map.get(key.random);
            }
        }

        return head2;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}