/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author ernesto
 */
public class Graph 
{
    private int vertices;
    private boolean [][] A;

    public Graph(int vertices) {
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
            System.out.println("ÍNDICE INVÁLIDO");
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
}