package Functions;

import EDD.DoubleLinkedList;
import EDD.AdjacencyMatrix;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//Clase pública Global, se encarga de modificar la variables estáticas de doubleList, file y adjMatrix a lo largo del programa
public class Global 
{
    //INICIALIZACIÓN DE LAS VARIABLES
    private static DoubleLinkedList doubleList;
    private static File file;
    private static AdjacencyMatrix adjMatrix;
    
    //Getters y Setters del constructor de la clase
    public static DoubleLinkedList getDoubleList() {
        return doubleList;
    }

    public static void setList(DoubleLinkedList list) {
        Global.doubleList = list;
    }

    public static File getFile() {
        return file;
    }

    public static void setFile(File file) {
        Global.file = file;
    }

    public static AdjacencyMatrix getAdjMatrix() {
        return adjMatrix;
    }

    public static void setAdjMatrix(AdjacencyMatrix adjMatrix) {
        Global.adjMatrix = adjMatrix;
    }
    
//Método CalculateVertex, recibe un string del archivo txt y calcula el número de vértices de nuestra matriz, retorna el número de vértices    
    public static int CalculateVertex(String filePath)
    {
        int cont = 0;
        try 
        {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            boolean readingUsers = false;

            while ((line = br.readLine()) != null)
            {
                // Si encontramos la palabra "usuarios" empezamos a leer los nombres de usuario
                if (line.equals("usuarios")) 
                {
                    readingUsers = true;
                    continue;  // Saltamos esta línea para no imprimir "usuarios"
                }
                // Si encontramos la palabra "relaciones" terminamos de leer los nombres de usuario
                if (line.equals("relaciones")) 
                {
                    readingUsers = false;
                    continue;
                }
                // Si estamos en la sección de usuarios creamos el nuevo objeto y lo añadimos a la matriz
                if (readingUsers) 
                {
                    //AÑADIMOS EL USUARIO A LA LISTA DOBLE
                    cont++;
                }
            }
            return cont;
        } 
        catch (IOException e) 
        {
        System.err.println("Error al leer el archivo: " + e.getMessage());
        return -1;
        }
    }
    
}
