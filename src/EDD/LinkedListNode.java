package EDD;

//Clase pública LinkedListNode, se encarga de crear los nodos simplemente enlazados
public class LinkedListNode 
{
    private Object data;
    private LinkedListNode next;
    
//Constructor de la clase, recibe un elemento de tipo object que se asocia al elemento del nodo y settea su apuntador siguiente en null
    public LinkedListNode(Object data) {
        this.data = data;
        this.next = null;
    }
    
//Getters y Setters del constructor de la clase
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }
}
