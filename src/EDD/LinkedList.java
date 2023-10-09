package EDD;

public class LinkedList 
{
    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isEmpty()
    {
        return getHead()==null;
    }
    
    public void InsertUser(String user)
    {
        Node node = new Node(user);
        if (isEmpty())
        {
            setHead(node);
        }
        else
        {
            Node pointer = getHead();
            while (pointer.getNext()!=null)
            {
                pointer = pointer.getNext();
            }
            pointer.setNext(node);
        }
        size++;
    }
}
