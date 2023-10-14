package EDD;


public class LinkedList 
{
    private LinkedListNode head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public LinkedListNode getHead() {
        return head;
    }

    public void setHead(LinkedListNode head) {
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
        LinkedListNode node = new LinkedListNode (line);
        if (isEmpty())
        {
            setHead(node);
        }
        else
        {
            LinkedListNode pointer = getHead();
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
        LinkedListNode pointer = getHead();
        while (pointer!=null)
        {
            System.out.println("Nodo: ["+pointer.getLine()+"] ");
            pointer = pointer.getNext();
        }
    }
    
    public void InsertBeforeRelations (String user)
    {
        LinkedListNode node = new LinkedListNode(user);
        LinkedListNode pointer = getHead();
        while (!pointer.getNext().getLine().equals("relaciones"))
        {
            pointer = pointer.getNext();
        }
        node.setNext(pointer.getNext());
        pointer.setNext(node);
        size++;
    }
    
    public LinkedList CleanList(String user)
    {
        LinkedList l = new LinkedList();
        LinkedListNode pointer = getHead();
        while (pointer!=null)
        {
            if (pointer.getLine().contains(user))
            {
                
            }
            else
            {
                l.InsertAtEnd(pointer.getLine());
            }
            pointer = pointer.getNext();
        }
        return l;
    }
}
