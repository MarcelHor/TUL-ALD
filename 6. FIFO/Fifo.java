public class Fifo {
    private Node first;
    private Node last;
    public Fifo(){
    }
    public Node pop(){
        if(first == null){
            return null;
        }
        Node tmp = first;
        first = first.previous;
        return tmp;
    }
    public void push(String value){
        if(first == null && last == null){
            first = new Node(null, value, null);
        }
        else if(last == null && first != null){
            last = new Node(null, value, first);
            first.previous = last;
        }
        else {
            Node tmp = last;
            last = new Node(null,value, tmp);
            tmp.previous = last;
        }
    }
    public boolean isEmpty(){
        return first == null? true:false;
    }
    public class Node {
        private Node previous;
        public String value;
        private Node next;
        public Node(Node previous, String value, Node next)
        {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}