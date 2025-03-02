class Solution {
    public static Listcode mergeKLists(Listcode[] lists) {
        Listcode mylist = null,listTemp=null;
        if(lists.length < 1)return mylist;

        while(!isListNull(lists)){
            Listcode temp=lists[0];
            int idx=0;
            for(int i=1;i<lists.length;i++){
                if(lists[i] != null && (temp == null || lists[i].val < temp.val)){
                    temp = lists[i];
                    idx = i;
                }
            }

            if(temp == null)break;
            if(mylist == null){
                 mylist = listTemp = temp;
            }
            else {
                listTemp.next = temp;
                listTemp = temp;
            }
            
            lists[idx] = lists[idx].next;
            temp.next = null;

            System.out.println("******");
            Problem_23.printList(lists[0]);
            Problem_23.printList(lists[1]);
            Problem_23.printList(lists[2]);
            System.out.println("*******\n");
            Problem_23.printList(mylist);
            System.out.println("######");
        }

        return mylist;
    }

    private static boolean isListNull(Listcode[] lists){
        for(int i=0;i<lists.length;i++){
            if(lists[i] != null)return false;
        }
        return true;
    }
}

public class Problem_23{
    public static void main(String[] args) {
        Listcode[] list = new Listcode[3];
        list[0] = add(1,4,5);
        list[1] = add(1,3,4);
        list[2] = add(2,6);
        // System.out.println("###################");
        // for(ListNode node : list){
        //     printList(node);
        // }
        // System.out.println("##############");


        Listcode node = Solution.mergeKLists(list);
        printList(node);
        
    }

    static Listcode add(int... list){
        Listcode head = null,temp = null;
        for(int i=0;i<list.length;i++){
            if(head == null){
                head = new Listcode(list[i]);
                temp = head;
            }else{
                temp.next = new Listcode(list[i]);
                temp = temp.next;
            }
        }
        
        return head;
    }


    static void printList(Listcode node){
        while(node != null){
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println("null");
    }
}