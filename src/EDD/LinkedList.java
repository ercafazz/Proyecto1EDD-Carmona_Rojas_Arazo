package EDD;

//Clase pública LinkedList, se encarga de la creación de la lista simplemente enlazada que maneja las relaciones de los usuarios
public class LinkedList 
{
    private LinkedListNode head;
    private int size;

//Constructor de la clase LinkedList, no recibe parámetros, settea el valor de cabeza en null y el tamaño en 0    
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }
    
//Getters y Setters del constructor de la clase
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
    
//Método isEmpty, no recibe parámetros y retorna un valor booleano true si la cabeza es igual a null    
    public boolean isEmpty()
    {
        return getHead() == null;
    }
    
//Método InsertAtEnd, recibe un elemento de tipo object, crea el nodo que contiene el element y lo añade al final de la lista, retorna vacío    
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
    
// Método Show, no recibe parámetros y retorna un print de los elementos asociados a cada nodo de la lista    
    public void Show()
    {
        LinkedListNode pointer = getHead();
        while (pointer!=null)
        {
            System.out.print(" ["+pointer.getData()+"] ");
            pointer = pointer.getNext();
        }
    }
    
//Método InsertBeforeRelations, recibe un elemento de tipo object, se encarga de guardar en el archivo txt las relacionas asociadas a un usuario, retorna vacío    
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
    
//Método CleanList, recibe un elemento de tipo object, se encarga de crear una nueva lista vacía y retorna la lista    
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
    
//Método Construct, recibe un tamaño de tipo int, se encarga de crear una lista enlazada con valores boolean false asociada a nuestra lista simplemente enlazada original, retorna vacío    
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
    
//Método CheckIfVisited, recibe un vértice de tipo int, recorre todos los valores false de nuestra lista enlazada con valores boolean y los settea como true, retorna los valores true    
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
    
//Método Deconstruct, no recibe parámetros, se encarga de volver a settear los valores de nuestra lista enlazada boolean en false, retorna vacía
    public void Deconstruct() 
    {
        LinkedListNode pointer = getHead();
        while (pointer!=null)
        {
            pointer.setData(false);
            pointer = pointer.getNext();
        }
    }
    
//Método deleteFinal, no recibe parámetros y elimina el último nodo de la lista y reduce su tamaño, retorna vacío        
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
    
//Método Clear, no recibe parámetros, limpia la lista setteando la cabeza en null y el tamaño en 0, retorna vacío    
    public void Clear()
    {
        this.setHead(null);
        this.size = 0;
    }
    
//Método SetAsVisited, recibe un índice de tipo int, se encarga de marcar el valor asociado al índice como true en nuestra lista de booleanos    
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
