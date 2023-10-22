/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import org.graphstream.graph.*;
import Functions.Global;
import javax.swing.JOptionPane;

/**
 *
 * @author ernesto
 */
public class AdjacencyMatrix 
{
    private int vertices;
    private boolean [][] A;

    public AdjacencyMatrix(int vertices) {
        this.vertices = vertices;
        this.A = new boolean[vertices][vertices];
    }

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