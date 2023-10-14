package EDD;

public class LinkedListNode 
{
    private String line;
    private LinkedListNode next;

    public LinkedListNode(String line) {
        this.line = line;
        this.next = null;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }
}
