package EDD;

public class Node 
{
    private String line;
    private Node next;

    public Node(String line) {
        this.line = line;
        this.next = null;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
    
}
