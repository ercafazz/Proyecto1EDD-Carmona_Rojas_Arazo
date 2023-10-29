/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import java.awt.Color;
import java.util.Random;
import org.graphstream.graph.*;
import javax.swing.JOptionPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

//Clase pública DoubleLinkedList, se encarga de la creación de la lista doblemente enlazada 
//además de todas las funciones necesarias en relación con la matriz, 
//el gráfico y los elementos dentro de la lista
public class DoubleLinkedList 
{
    private DoubleNode head;
    private DoubleNode tail;
    private int size;

//Constructor de la clase DoubleLinkedList, no recibe parámetros y settea los valores de cabeza y cola en nulo, también settea el tamaño en 0    
    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

//Getters y Setters del constructor de la clase    
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
    
//Método isEmpty, no recibe parámetros y retorna un valor booleano true si la cabeza es igual a null    
    public boolean isEmpty()
    {
        return getHead()==null;
    }
    
//Método Show, no recibe parámetros y retorna un print de los elementos asociados a cada nodo de la lista    
    public void Show()
    {
        DoubleNode pointer = getHead();
        while (pointer!=null)
        {
            System.out.print("["+pointer.getUser()+", "+pointer.getIndex()+"]");
            pointer = pointer.getNext();
        }
    }
    
//Método getUserIndex, recibe un usuario de tipo string y retorna el índice asociado al usuario, en caso de que el usuario no exista retorna -1    
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
    
//Método InsertUser, recibe un usuario de tipo string y tras checkear que no exista en la base de datos lo agrega y aumenta el tamaño de la lista, retorna vacío    
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
    
//Método DeleteUser, recibe un usuario de tipo string, ubica el usuario ingresado y lo elimina de la lista, después reduce en 1 todos los índices de los nodos siguientes para mantener el orden de la lista y reduce el tamaño, retorna vacío    
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
    
//Método DeleteFirst, no recibe parámetros y elimina el primer nodo dentro de la lista, reacomoda los índices en la lista y reduce su tamaño, retorna vacío    
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
    
//Método DeleteLast, no recibe parámetros y elimina el último nodo dentro de la lista, reduce el tamaño y retorna vacío    
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
    
//Método CalculateMatrixVertex, no recibe parámetros y retorna el tamaño de la lista     
    public int CalculateMatrixVertex()
    {
        return this.getSize();
    }
    
//Método returnName, recibe un índice de tipo int, retorna el usuario asociado al índice ingresado    
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
    
//Método InsertAtEnd, recibe un usuario de tipo string y lo inserta al principio de la lista, reacomoda los índices y aumenta el tamaño, retorna vacío    
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
    
//Método addItems, no recibe parámetros, añade los elementos de la lista al gráfico y retorna el gráfico
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
    
//Método addItemsWithColor, recibe un parámetro de tipo LinkedList, se encarga de buscar los componentes fuertemente conectados dentro de la lista simplemente enlanzada y le asigna un color aleatorio a cada grupo de nodos, retorna el gráfico
    public Graph addItemsWithColors(LinkedList scc) 
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
        
        LinkedListNode singlePointer = scc.getHead();
        while (singlePointer!=null)
        {
            Color randomColor = generateRandomColor();
            String rgbColor = String.format("rgb(%d,%d,%d)", randomColor.getRed(), randomColor.getGreen(), randomColor.getBlue());
            
            LinkedList l = (LinkedList) singlePointer.getData();
            LinkedListNode subPointer = l.getHead();
            
            while (subPointer!=null)
            {
                String id = subPointer.getData().toString();
                Node node = graph.getNode(id);
                node.setAttribute("ui.style", "fill-color: " + rgbColor + ";");
                subPointer=subPointer.getNext();
            }
            singlePointer = singlePointer.getNext();
        }
        
        return graph;
    }
    
//Método generateRandomColor, no recibe parámetros y retorna un color aleatorio    
    public static Color generateRandomColor() 
    {
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        return new Color(red, green, blue);
    }
}
