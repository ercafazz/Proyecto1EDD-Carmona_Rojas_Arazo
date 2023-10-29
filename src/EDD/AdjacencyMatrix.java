/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import org.graphstream.graph.*;
import Functions.Global;
import javax.swing.JOptionPane;

//Clase pública AdjacencyMatrix, se encarga de la creación y edición de las matrices 
//Se encargan de guardar los usuarios y establecer las relaciones, así como de ubicar estos parámetros
public class AdjacencyMatrix 
{
    private int vertices;
    private boolean [][] A;
    
//Constructor de la clase AdjacencyMatrix, recibe un valor int vertices y crea una nueva matriz de tipo boolean
    public AdjacencyMatrix(int vertices) {
        this.vertices = vertices;
        this.A = new boolean[vertices][vertices];
    }

//Getters y Setters del constructor de la clase    
    public int getVertices() {
        return vertices;
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

    public boolean[][] getMatrix() {
        return A;
    }

    public void setMatrix(boolean[][] matrix) {
        this.A = matrix;
    }
    
//Método AddRelation, recibe dos valores de tipo entero los cuales ubica en la matriz y marca el espacio con un valor de True, retorna vacío
    public void AddRelation(int i, int j)
    {
        if (i >= 0 && i < vertices && j >= 0 && j < vertices) 
        {
            A[i][j] = true;
        } else 
        {
            JOptionPane.showMessageDialog(null, "Estás intentando accedeer a un\níndice inválido en la matriz");
        }
    }
    
//Método Show, no recibe parámetros y su función es mostrar la matriz en consola, retorna un print en consola    
    public void Show()
    {
        System.out.println("");
        for (int i = 0; i < vertices; i++) 
        {
            for (int j = 0; j < vertices; j++) 
            {
                System.out.print("["+(A[i][j] ? 1 : 0)+"]" + "");
            }
            System.out.println("");
        }
    }
    
//Método AddVertex, no recibe parámetros, crea una nueva matriz con un vértice extra para copiar y pegar la matriz vieja y setea todos los nuevos espacios en falso, retorna vacío    
    public void AddVertex()
    {
        boolean [][]newA = new boolean[this.getVertices()+1][this.getVertices()+1];
        for (int i = 0; i < vertices; i++) 
        {
            for (int j = 0; j < vertices; j++) 
            {
                newA[i][j] = A[i][j];
            }
        }
        setMatrix(newA);
        vertices++;
    }

//Método FindeRelation, recibe dos usuarios de tipo int los cuales busca en la matriz e identifica si poseen relación, retorna true si la relación existe y false en el caso contrario    
    public boolean FindRelation(int user1, int user2) 
    {
        if (A[user1][user2] == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
//Método Delete, recibe un índice de tipo int con el que ubica al usuario asociado y elimina al mismo junto a las filas y columnas asociadas creando una matriz nueva con tamaño -1, retorna vacío    
    public void Delete(int index)
    {
        boolean [][] newA = new boolean[this.vertices-1][this.vertices-1];
        if (index==vertices-1)
        {
            for (int i = 0; i < vertices-1; i++) 
            {
                for (int j = 0; j < vertices-1; j++) 
                {
                    newA[i][j] = A[i][j];
                }
            }
        }
        else
        {
            //ELIMINAMOS FILA ASOCIADA
            for (int i = index; i < vertices-1; i++) 
            {
                for (int j = 0; j < vertices; j++) 
                {
                    A[i][j] = A[i + 1][j];
                }
            }
            //ELIMINAMOS COLUMNA ASOCIADA
            for (int i = 0; i < vertices; i++) 
            {
                for (int j = index; j < vertices-1; j++) 
                {
                    A[i][j] = A[i][j+1];
                }
            }
            //CREAMOS LA NUEVA MATRIZ
            for (int i = 0; i < vertices-1; i++) 
            {
                for (int j = 0; j < vertices-1; j++) 
                {
                    newA[i][j] = A[i][j];
                }
            }
        }
        //SET DE LA NUEVA MATRIZ
        Global.getAdjMatrix().setMatrix(newA);
        vertices--;
    }
    
//Método addVertexTo, recibe un gráfico de tipo Graph, declara puntos de origen y destino en la matriz para que se represente en el gráfico, retorna el gráfico    
    public Graph addVertexTo(Graph graph)
    {
        int id = 0;
        for (int i = 0; i < vertices; i++) 
        {
            for (int j = 0; j < vertices; j++) 
            {
                if (A[i][j] == true)
                {
                    String origin = String.valueOf(i);
                    String end = String.valueOf(j);
                    graph.addEdge(String.valueOf(id), origin, end, true);
                    id+=1;
                }
            }
        }
        return graph;
    }
    
//Método makeACopy, realiza una copia original de la matriz para utilizer en el algoritmo de Kosaraju, retorna la matriz copiada    
    public boolean [][] makeAcopy()
    {
        boolean [][] matrix = new boolean[this.vertices][this.vertices];
        boolean [][] self = this.getMatrix();
        for (int i = 0; i < this.vertices; i++) 
        {
            for (int j = 0; j < this.vertices; j++) 
            {
                matrix[i][j] = self[i][j];
            }
        }
        return matrix;
    }
}