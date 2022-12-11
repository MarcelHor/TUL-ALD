public class Lifo {
    private Node head;
    public Lifo(){
    }
    public Node pop(){
        if(head == null){
            return null;
        }
        Node top = head;
        head = top.next;
        return top;
    }
    public void push(String value){
        if(value == null){
            return;
        }
        Node previous = head;
        head = new Node(value, previous);
    }
    public boolean isEmpty(){
        return head == null? true:false;
    }
    public class Node {
        public String value;
        private Node next;
        public Node(String value, Node next)
        {
            this.value = value;
            this.next = next;
        }
    }
}
