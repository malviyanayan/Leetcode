class Leetcode707{

    static class MyLinkedList {

        private Node head,tail;
        private int size;

        static class Node{
            int val;
            Node prev;
            Node next;

            Node(int val){
                this.val = val;
                prev = next = null;
            }
        }

        public MyLinkedList() {
            head = tail = null;
            this.size = 0;
        }
        
        public int get(int index) {
            if(index < 0 || index >= size)return -1;
            int i = 0;
            Node temp = head;
            while(i != index){
                temp = temp.next;
                i++;
            }
            return temp.val;
        }
        
        public void addAtHead(int val) {
            Node node = new Node(val);
            if(head == null){
                head = tail = node;
            }
            else{
                head.prev = node;
                node.next = head;
                head = node;
            }
            size++;
        }
        
        public void addAtTail(int val) {
            Node node = new Node(val);
            if(tail == null)head = tail = node;
            else{
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
            size++;
        }
        
        public void addAtIndex(int index, int val) {
            if(index > size) return;

            if(index == size) {
                addAtTail(val);
            } else if(index == 0) {
                addAtHead(val);
            } else {
                int i = 0;
                Node temp = head;
                while(i != index) {
                    temp = temp.next;
                    i++;
                }
                Node node = new Node(val);
                temp.prev.next = node;
                node.prev = temp.prev;
                node.next = temp;
                temp.prev = node;
                size++;
            }
        }

        public void deleteAtIndex(int index) {
            if(index < 0 || index >= size) return;

            if(index == 0) {
                if(head == tail) {
                    head = tail = null;
                } else {
                    head = head.next;
                    head.prev = null;
                }
            } else if(index == size - 1) {
                tail = tail.prev;
                tail.next = null;
            } else {
                int i = 0;
                Node temp = head;
                while(i != index) {
                    temp = temp.next;
                    i++;
                }
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
            size--;
        }
    }


    
    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */


    public static void main(){

    }
}