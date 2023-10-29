/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

//Clase pública DoubleNode, se encarga de crear los nodos doblemente enlazados
class DoubleNode 
{
    private DoubleNode next;
    private DoubleNode prev;
    private Integer index;
    private String user;

//Constructor de la clase DoubleNode, recibe un usuario de tipo string que se asigna a user, settea los valores de siguiente, previo e índice en null    
    public DoubleNode(String user) {
        this.next = null;
        this.prev = null;
        this.index = null;
        this.user = user;
    }
    
//Getters y Setters del constructor de la clase
    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }

    public DoubleNode getPrev() {
        return prev;
    }

    public void setPrev(DoubleNode prev) {
        this.prev = prev;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
