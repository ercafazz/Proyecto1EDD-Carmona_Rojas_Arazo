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
    private Users matrix[][];

    public Graph(int vertices) {
        this.vertices = 0;
        this.matrix = new Users[vertices][vertices];
    }

    public int getVertices() {
        return vertices;
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

    public Users[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(Users[][] matrix) {
        this.matrix = matrix;
    }
    
    public void AddUser(Users user)
    {
        
    }
    
    public int CalculateVertex(String filepath)
    {
        try 
            {
            // Lee el archivo
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String line;
            boolean readingUsers = false;
            int vertices = 0;
            while ((line = br.readLine()) != null) {
                // Si encontramos la palabra "usuarios", empezamos a leer los nombres de usuario
                if (line.equals("usuarios")) {
                    readingUsers = true;
                    continue;  // Saltamos esta línea para no imprimir "usuarios"
                }

                // Si encontramos la palabra "relaciones", terminamos de leer los nombres de usuario
                if (line.equals("relaciones")) {
                    readingUsers = false;
                    break;  // Dejamos de leer
                }

                // Si estamos en la sección de usuarios, mostramos el nombre de usuario
                if (readingUsers) {
                    vertices+=1;
                }
            }
            br.close();
            return vertices;
     
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return -1;
    }
}