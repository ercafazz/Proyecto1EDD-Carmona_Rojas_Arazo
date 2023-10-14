/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import org.graphstream.graph.*;
import javax.swing.JOptionPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

/**
 *
 * @author ernesto
 */
public class DoubleLinkedList 
{
    private DoubleNode head;
    private DoubleNode tail;
    private int size;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public DoubleNode getHead() {
        return head;
    }

    public void setHead(DoubleNode head) {
        this.head = head;
    }

    public DoubleNode getTail() {
        return tail;
    }

    public void setTail(DoubleNode tail) {
        this.tail = tail;
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
    
    public void Show()
    {
        DoubleNode pointer = getHead();
        while (pointer!=null)
        {
            System.out.print("["+pointer.getUser()+", "+pointer.getIndex()+"]");
            pointer = pointer.getNext();
        }
    }
    
    public int getUserIndex(String user)
            //RETORNA EL ÍNDICE DEL USUARIO
    {
        DoubleNode pointer = getHead();
        while (pointer!=null)
        {
            if (pointer.getUser().equals(user))
            {
                return pointer.getIndex();
            }
            pointer = pointer.getNext();
        }
        // SI EL USUARIO NO ES ENCONTRADO RETORNA -1
        return -1;
    }
    
    public void InsertUser(String user)
    {
        int n = getUserIndex(user);
        if (n!=-1)
        {
            JOptionPane.showMessageDialog(null, "Este usuario ya existe, intente de nuevo");
        }
        else
        {
            DoubleNode node = new DoubleNode(user);
            if (isEmpty())
            {
                setHead(node);
                setTail(node);
                node.setIndex(0);
            }
            else
            {
                getTail().setNext(node);
                node.setPrev(getTail());
                node.setIndex(getTail().getIndex()+1);
                setTail(node);
            }
            size++;
        }
    }
    
    public void DeleteUser(String user)
    {
        int n = getUserIndex(user);
        if (n==-1)
        {
            System.out.println("No existe este usuario");
        }
        else if (n==getTail().getIndex())
        {
            DeleteLast();
        }
        else if (n ==getHead().getIndex())
        {
            DeleteFirst();
        }
        else
        {
            DoubleNode pointer = getHead();
            while (pointer !=null)
            {
                if (pointer.getNext().getIndex()==n)
                {
                    DoubleNode left = pointer;
                    DoubleNode middle = left.getNext();
                    DoubleNode right = middle.getNext();
                    
                    left.setNext(right);
                    right.setPrev(left);
                    middle.setPrev(null);
                    middle.setNext(null);
                    middle.setIndex(null);
                    break;
                }
                pointer = pointer.getNext();
            }
            pointer = pointer.getNext();
            while (pointer!=null)
            {
                pointer.setIndex(pointer.getIndex()-1);
                pointer = pointer.getNext();
            }
            size--;
        }
    }
    
    public void DeleteFirst()
    {
        if (isEmpty())
        {
            System.out.println("LISTA VACÍA");
        }
        else
        {
            if (getHead()==getTail())
            {
                getHead().setIndex(null);
                setHead(null);
                setTail(null);
            }
            else
            {
                DoubleNode pointer = getHead();
                setHead(pointer.getNext());
                pointer.setNext(null);
                pointer.setIndex(null);
                getHead().setPrev(null);
                
                pointer = getHead();
                while (pointer!=null)
                {
                    pointer.setIndex(pointer.getIndex()-1);
                    pointer = pointer.getNext();
                }
            }
            size--;
        }
    }
    
    public void DeleteLast()
    {
        if (isEmpty())
        {
            System.out.println("LISTA VACIA");
        }
        else
        {
            if (getHead()==getTail())
            {
                setHead(null);
                setTail(null);
            }
            else
            {
                DoubleNode pointer = getTail();
                setTail(pointer.getPrev());
                pointer.setIndex(null);
                getTail().setNext(null);
                pointer.setPrev(null);
            }
            size--;
        }
    }
    
    public int CalculateMatrixVertex()
    {
        return this.getSize();
    }
    
    public String returnName(int index)
    {
        DoubleNode pointer = getHead();
        while (pointer!=null)
        {
            if (pointer.getIndex()==index)
            {
                return pointer.getUser();
            }
            pointer = pointer.getNext();
        }
        return null;
    }
    
    public void InsertAtEnd(String line)
    {
        DoubleNode node = new DoubleNode(line);
        if (isEmpty())
        {
            setHead(node);
            setTail(node);
        }
        else
        {
            getTail().setNext(node);
            node.setPrev(getTail());
            setTail(node);
        }
        size++;
    }

    public Graph addItems() 
    {
        System.setProperty("org.graphstream.ui", "swing");
        Graph graph = new SingleGraph("Graph");
        String stylesheet = "node { z-index: 1; text-mode: normal; text-alignment: center; text-background-mode: none; text-size: 15; size: 60px; fill-mode: dyn-plain; text-color: white; } edge { z-index: 0; arrow-shape: arrow; fill-mode: dyn-plain; }";
        graph.setAttribute("ui.stylesheet", stylesheet);

        DoubleNode pointer = getHead();
        while (pointer!=null)
        {
            String index = String.valueOf(pointer.getIndex());
            Node node = graph.addNode(index);
            String name = pointer.getUser();
            node.setAttribute("ui.label", name);
            pointer = pointer.getNext();
        }
        return graph;
    }
}
