package EDD;

public class Node 
{
    String user;
    Node next;

    public Node(String user) {
        this.user = user;
        this.next = null;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
