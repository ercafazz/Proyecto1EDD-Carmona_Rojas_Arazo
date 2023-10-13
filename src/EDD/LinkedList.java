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
        return getHead() == null;
    }
    
    public void InsertAtEnd (String line)
    {
        Node node = new Node (line);
        if (isEmpty())
        {
            setHead(node);
        }
        else
        {
            Node pointer = getHead();
            while (pointer.getNext()!=null)
            {
                pointer=pointer.getNext();
            }
            pointer.setNext(node);
        }
        size++;
    }
    
    public void Show()
    {
        Node pointer = getHead();
        while (pointer!=null)
        {
            System.out.println(" ["+pointer.getLine()+"] ");
            pointer = pointer.getNext();
        }
    }
    
    public void InsertBeforeRelations (String user)
    {
        Node node = new Node(user);
        Node pointer = getHead();
        while (!pointer.getNext().getLine().equals("relaciones"))
        {
            pointer = pointer.getNext();
        }
        node.setNext(pointer.getNext());
        pointer.setNext(node);
        size++;
    }
    
}
