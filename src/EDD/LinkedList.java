package EDD;

import Functions.Global;
import java.awt.Color;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import java.util.Random;


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
    
    public void InsertAtEnd (Object data)
    {
        LinkedListNode node = new LinkedListNode (data);
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
            System.out.print(" ["+pointer.getData()+"] ");
            pointer = pointer.getNext();
        }
    }
    
    public void InsertBeforeRelations (Object data)
    {
        LinkedListNode node = new LinkedListNode(data);
        LinkedListNode pointer = getHead();
        while (!pointer.getNext().getData().equals("relaciones"))
        {
            pointer = pointer.getNext();
        }
        node.setNext(pointer.getNext());
        pointer.setNext(node);
        size++;
    }
    
    public LinkedList CleanList(Object data)
    {
        LinkedList l = new LinkedList();
        LinkedListNode pointer = getHead();
        while (pointer!=null)
        {
            String s = pointer.getData().toString();
            if (s.contains(data.toString()))
            {
                
            }
            else
            {
                l.InsertAtEnd(pointer.getData());
            }
            pointer = pointer.getNext();
        }
        return l;
    }
    
    public void Construct(int length)
    {
        boolean b = false;
        int cont = 1;
        while (cont<=length)
        {
            LinkedListNode node = new LinkedListNode(null);
            InsertAtEnd(node);
            cont++;
        }
        LinkedListNode pointer = getHead();
        while (pointer!=null)
        {
            pointer.setData(b);
            pointer = pointer.getNext();
        }
    }
    
    public boolean CheckIfVisited(int vertex) 
    {
        LinkedListNode pointer = getHead();
        int cont = 0;
        while (cont != vertex)
        {
            pointer = pointer.getNext();
            cont++;
        }
        return (boolean) pointer.getData();
    }

    public void Deconstruct() 
    {
        LinkedListNode pointer = getHead();
        while (pointer!=null)
        {
            pointer.setData(false);
            pointer = pointer.getNext();
        }
    }
    
    public Object deleteFinal() {
    if (isEmpty()) {
        System.out.println("La lista está vacía");
        return null;
    } else if (getHead().getNext() == null) {
        // Solo hay un elemento en la lista, eliminar la cabeza
        LinkedListNode temp = getHead();
        setHead(null);
        size--;
        return temp.getData();
    } else {
        LinkedListNode pointer = getHead();
        while (pointer.getNext().getNext() != null) {
            pointer = pointer.getNext();
        }
        LinkedListNode temp = pointer.getNext();
        pointer.setNext(null);
        size--;
        return temp.getData();
    }
}
    
    public void Clear()
    {
        this.setHead(null);
        this.size = 0;
    }
    
    public void SetAsVisited(int index)
    {
        if (isEmpty())
        {
            
        }
        else
        {
            int cont = 0;
            LinkedListNode pointer = getHead();
            
            while (cont!=index)
            {
                pointer = pointer.getNext();
                cont++;
            }
            pointer.setData(true);
        }
    }

}
